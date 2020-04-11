$(document).ready(function(){
    var arr = [];
    $("#button").click(function(){
        var datePosted = Date.now();
        var str = "";
        var commentStart = "<li class='list-group-item'><h5 class='card-title'>";
        var nameComment = "</h5><p class='card-text'>";
        var commentTime = "</p><div class='card-footer text-muted'>";
        var commentEnd = "";

        if ($("#name").val() == "" || $("#username").val() == "" || $("#comment").val() == ""){
            alert("The name or username or comment has not bee entered");
        }
        else{
            var input ={username:$("#username").val(), name:$("#name").val(), comment:$("#comment").val(), time:datePosted};
            arr.push(input);
        }
        for(i=0;i<arr.length;i++){
            var timeAgo = Math.floor((datePosted - arr[i].time)/1000);
            commentEnd = "Just now</div></li>";
            if(timeAgo > 0){
                commentEnd = timeAgo + " seconds ago</div></li>";
            }
            if (timeAgo >= 60){
                timeAgo = Math.floor(timeAgo/60);
                commentEnd = timeAgo + " minutes ago</div></li>";
            }
            if (timeAgo >=60){
                timeAgo = Math.floor(timeAgo/60);
                commentEnd = timeAgo + " hours ago</div></li>";
            }
        str += commentStart + arr[i].name + " @" + arr[i].username + nameComment + arr[i].comment + commentTime + commentEnd;
        }

        $("#commentSection").html(str);
        $("#comment").val("");
        $("#name").val("");
        $("#username").val("");
    });
});
