var express = require('express');
var mongoose = require('mongoose');
var rootRouter = require('./routers/root');
var voteController = require('./controllers/voteController');

var app = express();

mongoose.set('useNewUrlParser', true);
mongoose.set('useUnifiedTopology', true);
mongoose.connect('mongodb+srv://ct414-assignment2:ct414-assignment2@cluster0.ud0of.mongodb.net/ct414-assignment2?retryWrites=true&w=majority');
mongoose.connection.on('error', (err) => {
    console.log('Mongoose Connection Error!', err);
});

// set up template engine
app.set('view engine', 'ejs');
// static files
app.use(express.static('./public'));

// setup routes
app.use('/', rootRouter);

// init the votes collection if its not already initialised
voteController.initCollectionIfNotAlready();

// listen to port
app.listen(3000);
console.log('Listeneing on port 3000');
