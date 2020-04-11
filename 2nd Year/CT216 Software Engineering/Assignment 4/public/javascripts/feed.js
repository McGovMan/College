$(document).ready(
    function() {
        var totalCharacters = 280;
        console.log("Page Loaded, cookies are ", document.cookie);

        $("#inputPost").keyup(function (event) {
            var inputText = event.target.value;
            $("#charRemaining").html(totalCharacters - inputText.length);
        });

        getComments();
        /**
         * When the page loads (or is refreshed) we request all comments from the server
         */
        function getComments() {			
            $.ajax({
                url: '/getComments/',
                type: 'GET',
                success: function (data) {
                    var posts = "";
                    for (var i = 0; i < data.length; i++) {
                        posts += "<div class='row justify-content-md-center pt-4'>" +
                            "<div class='card col-md-6'><div class='row'>"
                            + "<div class='col-md-9'>"+ data[i].message + "</div>" + "<div class='col-md-3'>" +
                            "<button type='button' name='delete " + data[i]._id + "' class='btn btn-danger'>" +
                            "Delete</button></div></div></div></div>";
                    }
                    $("#feedPosts").html(posts);
                }
            });
            
        }
});
