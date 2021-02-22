<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Net salary</title>
    <meta charset="UTF-8">
    <link href="style.css" rel="stylesheet">

    <style>
        #home img{
            width:33px;
            height:30px;
            margin-top:5px;
            margin-left:15px;
            float:left;
        }
        #home:hover{
            transform:scale(1.1);
        }
        #Result{
            color:#67a6e5;
        }

    </style>

     <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
     <script type="text/javascript">
        $(document).ready(function(){
            $('#btnSubmit').click(
                function(event){

                var Gross =  $('#Gross').val();
                var Sector = $('#Sector').val();
                var Year = $('#Year').val();
                var Percentage = $('#Percentage').val();
                var Citizen = $('.Citizen:checked').val();

                   $.ajax({
                        type:'POST',
                        url:'GrossToNetSalaryCalculation',
                        data: {Gross:Gross,
                                Sector:Sector,
                                Year:Year,
                                Percentage:Percentage,
                                Citizen:Citizen},
                        success: function(resultText){
                            $('#Result').html(resultText);
                            $(".Citizen:checked").prop("checked",false);
                            }
                    });

                });
            });

     </script>

</head>

<body>
   <script>
        function ShowDiv() {
            		var myContainer = document.getElementById("Container");
            		var myCheck = document.getElementById("myCheckBox");
            		if (myCheck.checked == true) {
            			myContainer.style.display = "block";
            		} else if(myCheck.checked == false){
            			myContainer.style.display = "none";
                    }
            	}

    </script>
<span id="home"><a href = "index.html"><img alt="Home" src="img/home.png"></a></span>
<div class="Xurcun">
    <form action="GrossToNetSalaryCalculation" method="POST">

        <legend>Hesablanan aylıq əmək haqqı</legend>
        <input type="text" name="Gross" id="Gross"><br>

        <legend>Hesablanan əmək haqqının faizi</legend>
        <input type="text" name="Percentage" id="Percentage"><br>

       Güzəştlər <input type="checkbox" name="Concession" onclick="ShowDiv()" id="myCheckBox" value="G"/>
         <div id="Container" style="display:none">
         <input type="radio" name="val" value="2" class="Citizen">V.M. 102-2 Vergi tutulan gəlir 400 AZN azaldılır</input><br>
         <input type="radio" name="val" value="3" class="Citizen">V.M. 102-3 Vergi tutulan gəlir 200 AZN azaldılır</input><br>
         <input type="radio" name="val" value="4" class="Citizen">V.M. 102-4 Vergi tutulan gəlir 100 AZN azaldılır</input><br>
         <input type="radio" name="val" value="5" class="Citizen">V.M. 102-5 Vergi tutulan gəlir 50 AZN azaldılır</input><br>
         </div><br>

        <legend>Sektor</legend>
        <input type="text" list="sectors" name="Sector" id="Sector">
        <datalist id="sectors">
            <option value="Dövlət və Neft-qaz sektoru">
            <option value="Qeyri neft-qaz və özəl sektor">
        </datalist> <br>

        <legend>Tarix</legend>
        <input type="text" list="years" name="Year" id="Year">
        <datalist id="years">
            <option value="2017">
            <option value="2018">
            <option value="2019">
            <option value="2020">
        </datalist><br>

        <input type="button" value="Hesabla" id="btnSubmit"><br>

        <legend> Nəticə </legend><br>
        <div id="Result">  </div>
    </form>

</div>
</body>
</html>