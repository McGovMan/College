$(document).ready(function() {

  // When the row of the programming language is clicked:
  // - get the ID accociated with the language
  // - send a post request to the server with that ID
  // - handle error or reload the page
  $('tr').on('click', function(){
      if ($(this).children('th').length) {
        // is the header tr, dont do anything
      } else {
        var id = $(this).children('#language-id').text();
        $.ajax({
          type: 'POST',
          url: '/vote/' + id,
          statusCode: {
            200: function (response) {
              location.reload();
            },
            400: function (response) {
              alert("Invalid Vote Selection");
            },
            500: function (response) {
              alert("Server Error");
            }
          }
        });
      }
  });

});
