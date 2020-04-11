var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Comments' });
});

router.get('/getComment/:id',function(req,res,next) {
	var id = req.params.id;
	Comment.find({_id:id}, function(err, comment) {
		if(err)
			throw err;
		res.json(comment);
	})
});

/* GET feed page. */
router.get('/feed', function(req,res,next) {
	res.render('feed');
});

module.exports = router;
