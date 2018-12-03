
var getNewStatusRequest = new XMLHttpRequest();


function getNewStatus(){
    getNewStatusRequest.open("GET", "Controller?action=Status", true);
    getNewStatusRequest.onreadystatechange = getData;
    getNewStatusRequest.send(null);
}


function getData(){
    if(getNewStatusRequest.readyState == 4){
        if(getNewStatusRequest.status == 200){
            var status = getNewStatusRequest.responseText;
            var p = document.getElementById("status");
            var textNode = document.createTextNode(status);
            p.appendChild(textNode);

           // setInterval(getNewStatus, 2000);


            /*   var serverResponse = JSON.parse(getNewStatusRequest.responseText);
               var statusXML = serverResponse.status;

               var statusDiv = document.getElementById("status");
               var statusParagraph = statusDiv.childNodes[0];

               if(statusParagraph == null){
                   statusParagraph = document.createElement('p');
                   statusParagraph.id = "statusText";
                   var statusText = document.createTextNode(statusXML);
                   statusParagraph.appendChild(statusText);
                   statusDiv.appendChild(statusParagraph);
               }
               else{
                   var statusText = document.createTextNode(statusXML);
                   statusParagraph.removeChild(statusParagraph.childNodes[0]);
                   statusParagraph.appendChild(statusText);
               }

   */


        }
    }
}
