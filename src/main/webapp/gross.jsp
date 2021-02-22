<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Gross salary</title>
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
    </style>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
        $('#btnSubmit').click(
            function(event){

            var Net =  $('#Net').val();
            var Sector = $('#Sector').val();
            var Year = $('#Year').val();

               $.ajax({
                    type:'POST',
                    url:'NetToGrossSalaryCalculation',
                    data: {Net:Net, Sector:Sector, Year:Year},
                    success: function(resultText){
                        $('#Result').html(resultText);
                        }
                });
            });
        });


    </script>
</head>

<body>
<span id="home"><a href = "index.html"><img alt="Home" src="img/home.png" ></a></span>
<div class="Xurcun">

    <form action="NetToGrossSalaryCalculation" method="POST">

        <legend>NETT aylıq əmək haqqı</legend>
        <input type="text" name="Net" id="Net"><br>

        <legend>Sektor</legend>
        <input type="text" list="sectors" name="Sector" id="Sector">
        <datalist id="sectors">
            <option value=" Dövlət və Neft-qaz sektoru ">
            <option value=" Qeyri neft-qaz və özəl sektor ">
        </datalist><br>

    <legend>Tarix</legend>
            <input type="text" list="years" name="Year" id="Year">
            <datalist id="years">
                <option value="2018">
                <option value="2019">
            </datalist><br>

        <input type="button" value="Hesabla" id="btnSubmit"><br>

        <legend>Nəticə</legend><br>
        <span id="Result"> </span>
    </form>

</div>
</body>
</html>