<!DOCTYPE HTML>

<html>
<head>
    <title>Salon Job HK</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.scrolly.min.js"></script>
    <script src="js/jquery.dropotron.min.js"></script>
    <script src="js/jquery.scrollex.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/skel-layers.min.js"></script>
    <script src="js/init.js"></script>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <noscript>
        <link rel="stylesheet" href="css/skel.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/style-xlarge.css" />
    </noscript>
    <!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
    <!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->

</head>
<body>

<!-- Header -->


<!-- Main -->



<div id="main" class="wrapper style1">
    <div class="container">


        <form ACTION="<?php echo $loginFormAction; ?>" name="form1" method="POST">



            <div class="12u$">
                <input type="username" name="username" required id="username"  pattern="[A-Z]{1}[0-9]{7}"  maxlength="20" value="" placeholder="User Name"/>
            </div>
            <br>

            <div class="12u$">
                <input type="password" name="password" required id="password"  maxlength="8" placeholder="" />
            </div>

            <br>
            <div class="12u$">
                <input type="checkbox" name="remember" id="remember" />
                <label for="remember">Remember me</label>

            </div>


            <INPUT Type="submit" class="button special fit" name="Login" id="Login" value="login">

        </form>


        <script>
            //remember username and password
                        $(function() {

                            if (localStorage.chkbx && localStorage.chkbx != '') {
                                $('#sremember').attr('checked', 'checked');
                                $('#tel').val(localStorage.tel);
                                $('#spassword').val(localStorage.spassword);
                            } else {
                                $('#sremember').removeAttr('checked');
                                $('#tel').val('');
                                $('#spassword').val('');
                            }

                            $('#sremember').click(function() {

                                if ($('#sremember').is(':checked')) {
                                    // save username and password
                                    localStorage.tel = $('#tel').val();
                                    localStorage.spassword = $('#spassword').val();
                                    localStorage.chkbx = $('#sremember').val();
                                } else {
                                    localStorage.tel = '';
                                    localStorage.spassword = '';
                                    localStorage.chkbx = '';
                                }
                            });
                        });

            </script>

    </div>
</div>

</body>
</html>