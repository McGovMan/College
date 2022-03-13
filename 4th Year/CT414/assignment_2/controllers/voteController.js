
var mongoose = require('mongoose');
const Language = require('../models/language');

exports.getVotes = async (req, res, next) => {
  Language.find({}, function(err, data){
    // This should basically never have an error unless
    // the MongoDB is unreachable
    if (err) return res.sendStatus(500);
    return res.render('language', {languages: data});
  });
}

exports.addVote = async (req, res, next) => {
  var id = req.params.id;
  if (!mongoose.isValidObjectId(id)) return res.sendStatus(400);

  Language.findByIdAndUpdate(id, {$inc: {"votes": 1}}, function(err, data) {
    if (err || data == null) return res.sendStatus(400);
    console.log("DEBUG: " + data.name + " vote incremented by 1");
    return res.sendStatus(200);
  });
}

exports.initCollectionIfNotAlready = async () => {
  Language.find({}, function(err, data) {
    if (err) throw err;
    if (data.length == 0) {
      let row = {"name": "Javascript", "votes": 0};
      Language(row).save(function(err){ if (err) throw err; });
      row = {"name": "C", "votes": 0};
      Language(row).save(function(err){ if (err) throw err; });
      row = {"name": "C++", "votes": 0};
      Language(row).save(function(err){ if (err) throw err; });
      row = {"name": "COBAL", "votes": 0};
      Language(row).save(function(err){ if (err) throw err; });
      row = {"name": "Java", "votes": 0};
      Language(row).save(function(err){ if (err) throw err; });
      console.log("DEBUG: Collection initialised");
    }
  });
}