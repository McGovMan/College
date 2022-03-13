const express = require('express');
const voteController = require('../controllers/voteController');
const router = express.Router();

router.get('/vote', voteController.getVotes);
router.post('/vote/:id', voteController.addVote);

module.exports = router;