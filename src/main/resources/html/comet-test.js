
google.load("jquery", "1");

/**
 * Callback function - Cometd consumer.
 */
google.setOnLoadCallback(function() {
    $.getScript("http://jquerycomet.googlecode.com/svn/trunk/jquery.comet.js", function(){
    console.log("done loading js");
    $.comet.init("http://localhost:9099/cometd");
    $.comet.subscribe("/broadcastMessageChannel", broadcastListener);
  });
  
});

/**
 * Listener function called on receipt of broadcast message.
 */
function broadcastListener(msg) {
  console.log("received broadcast: " + msg + ", " + msg.data); 
  $('<li>').html(msg.data).prependTo('#contentList').animate({color: "#000000"}, 6000);
  $('html, body').animate({ scrollTop: 0 }, 0);
}




