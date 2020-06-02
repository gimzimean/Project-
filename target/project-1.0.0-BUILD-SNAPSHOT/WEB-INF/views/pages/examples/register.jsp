<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 3 | Registration Page</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet" href="/resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- icheck bootstrap -->
<link rel="stylesheet" href="/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/resources/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
			<a href="*.band?cmd="><b>BAND</b></a>
		</div>

		<div class="card">
			<div class="card-body register-card-body">
				<p class="login-box-msg">Register a new membership</p>

				<form action="/user/join" method="post" name="form">

					<div class="input-group mb-3">
						<input id="username" name="username" type="text" class="form-control" placeholder="Full name" required="required">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>
					</div>
					<div class="invalid-feedback" id="nameError">이름을 정확히 기입해주세요.</div>

					<div class="input-group mb-3">
						<input id="email" name="email" type="email" class="form-control" placeholder="Email" required="required">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input name="password" type="password" class="form-control" placeholder="Password" required="required" id="pwd1">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input name="repassword" type="password" class="form-control" placeholder="Retype password" required="required" id="pwd2">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>

					<div class="invalid-feedback" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
					<div class="valid-feedback" id="alert-success">비밀번호가 일치합니다.</div>


					<div class="row">
						<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" id="agreeTerms" name="agreeTerms" value="agree"> <label for="agreeTerms"> I agree to the <a href="#">terms</a>
								</label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button id="submit" type="submit" class="btn btn-primary btn-block">Register</button>
						</div>
						<!-- /.col -->
					</div>
				</form>

				<div class="social-auth-links text-center">
					<p>- OR -</p>
					<a href="#" class="btn btn-block btn-primary"> <i class="fab fa-facebook mr-2"></i> Sign up using Facebook
					</a> <a href="#" class="btn btn-block btn-danger"> <i class="fab fa-google-plus mr-2"></i> Sign up using Google+
					</a>
				</div>

				<a href="login.html" class="text-center">I already have a membership</a>
			</div>
			<!-- /.form-box -->
		</div>
		<!-- /.card -->
	</div>
	<!-- /.register-box -->




	<!-- jQuery -->
	<script src="/resources/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/resources/dist/js/adminlte.min.js"></script>
</body>
<script type="text/javascript">
	//비밀번호 일치여부
	$(function() {
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$("#pwd2").keyup(function() {
			var pwd1 = $("#pwd1").val();
			var pwd2 = $("#pwd2").val();
			if (pwd1 != "" || pwd2 != "") {
				if (pwd1 == pwd2) {
					$("#alert-success").show();
					$("#alert-danger").hide();
					$("#pwd1").removeClass('is-invalid');
					$("#pwd2").removeClass('is-invalid');
					$("#pwd1").addClass('is-valid');
					$("#pwd2").addClass('is-valid');
					$("#submit").removeAttr("disabled");
				} else {
					$("#alert-success").hide();
					$("#alert-danger").show();
					$("#pwd1").removeClass('is-valid');
					$("#pwd2").removeClass('is-valid');
					$("#pwd1").addClass('is-invalid');
					$("#pwd2").addClass('is-invalid');
					$("#submit").attr("disabled", "disabled");
				}
			}
		});
	});

	$("#username").keyup(function() {
		var KorEngpattern = /([^가-힣\x20a-zA-Z])/i; //한글과 영어만

		var username = $('#username').val();
		$('#nameError').hide();
		if (KorEngpattern.test(username)) { //패턴에 포함되지 않은 문자 메세지 출력
			$('#nameError').show();
			$("#username").removeClass('is-valid');
			$("#username").addClass('is-invalid');
			$("#submit").attr("disabled", "disabled");
			return false;
		} else {
			$("#username").removeClass('is-invalid');
			$("#username").addClass('is-valid');
			$("#submit").removeAttr("disabled");
			return true;
		}
	});
	
	$("#email").keyup(function() {
		var emailPattern =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 정규식
		var email=$('#email').val();
		if (email.match(emailPattern)!=null) {
			$('#email').removeClass('is-invalid');
			$('#email').addClass('is-valid');
			$("#submit").removeAttr("disabled");
			return true;

		}else {
			$('#email').removeClass('is-valid');
			$('#email').addClass('is-invalid');
			$("#submit").attr("disabled", "disabled");
			return false;
		}
	});
	
	//체크박스 약관동의 여부
	$('#submit')
			.on(
					'click',
					function() {

						var agreeTerms = document.form.agreeTerms.checked;
						var mbrPwd = $("#pwd1").val(); // pw 입력

						var check1 = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/
								.test(mbrPwd); //영문,숫자
						var check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/
								.test(mbrPwd); //영문,특수문자
						var check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/
								.test(mbrPwd); //특수문자, 숫자

						if (!agreeTerms) {
							alert('약관에 동의해주세요');
							return false;
						}

						if (!(check1 || check2 || check3)) {

							alert("특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내로 입력해주세요.");

							return false;

						}

						if (/(\w)\1\1/.test(mbrPwd)) {

							alert('같은 문자를 3번 이상 사용하실 수 없습니다.\n패스워드 설정안내를 확인해 주세요.');

							return false;

						}

						return true;

					});
</script>
</html>
