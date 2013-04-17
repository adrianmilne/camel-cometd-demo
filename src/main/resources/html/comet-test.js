
google.load("jquery", "1");

google.setOnLoadCallback(function() {
  $.getScript("http://jquerycomet.googlecode.com/svn/trunk/jquery.comet.js", function(){
    console.log("done loading js");
    $.comet.init("http://localhost:9099/cometd");
    $.comet.subscribe("/broadcastMessageChannel", receive);
  });
  
});

function receive(message) {
  console.log("message: " + message + ", " + message.data + ", header: " + message.header );
  
  $('<li>').html(message.data).prependTo('#contentList').animate({color: "#000000"}, 6000);
  $('html, body').animate({ scrollTop: 0 }, 0);
}




