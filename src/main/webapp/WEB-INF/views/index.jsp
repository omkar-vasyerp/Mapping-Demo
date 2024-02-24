<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Mapping Demo</title>

    </head>

    <body>

        <select name="country" id="country" onchange="onchanegeFunction()"> </select>
        <select name="state" id="state" onchange="onchanegeFunction1()"> </select>
        <select name="country" id="country" onchange="onchanegeFunction()"> </select>







        <script src="https://code.jquery.com/jquery-3.7.1.slim.min.js"
            integrity="sha256-kmHvs0B+OpCW5GVHUNjv9rOmY0IvSIRcf7zGUDTDQM8=" crossorigin="anonymous"></script>
        <script>
            window.onload=function onload(){
               var selCountry= document.getElementById(country)

               $.ajax({
                type:'GET',
                url:'http://localhost:8080/api/country',
                success: function(response){

                    var newOption=$('<Option>');
                        Option.attr('value',"").text("Select Country");
                        Option.attr("id",0);
                        $('#country').append('newOption');

                }
               })
            }

        </script>
    </body>

    </html>