var node1 = document.createTextNode("message = " + myMessage);
var node2 = document.createTextNode("number = " + number);
document.getElementById('message-ext').append(node1);
document.getElementById('number-ext').append(node2);