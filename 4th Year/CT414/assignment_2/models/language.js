const mongoose = require('mongoose');

var languageSchema = new mongoose.Schema({
    name: String,
    votes: Number
});

module.exports = mongoose.model('Language', languageSchema);