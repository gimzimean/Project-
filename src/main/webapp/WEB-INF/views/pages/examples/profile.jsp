<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html style="height: auto;">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 3 | User Profile</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="/resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/resources/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">






<style>
.MultiCarousel {
	float: left;
	overflow: hidden;
	padding: 15px;
	width: 100%;
	position: relative;
}

.MultiCarousel .MultiCarousel-inner {
	transition: 1s ease all;
	float: left;
}

.MultiCarousel .MultiCarousel-inner .item {
	float: left;
}

.MultiCarousel .MultiCarousel-inner .item>div {
	text-align: center;
	padding: 10px;
	margin: 10px;
	background: #f1f1f1;
	color: #666;
}

.MultiCarousel .leftLst, .MultiCarousel .rightLst {
	position: absolute;
	border-radius: 50%;
	top: calc(50% - 20px);
}

.MultiCarousel .leftLst {
	left: 0;
}

.MultiCarousel .rightLst {
	right: 0;
}

.MultiCarousel .leftLst.over, .MultiCarousel .rightLst.over {
	pointer-events: none;
	background: #ccc;
}
</style>

</head>
<body class="sidebar-mini" style="height: auto;">
	<div class="wrapper">
		<!-- Navbar -->
		<%@include file="../../include/nav.jsp"%>



		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="min-height: 1416.81px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Create</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">User Profile</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>


			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">


						<!-- Profile Image -->
						<div class="MultiCarousel col-md-12" data-items="1,3,5,6"
							data-slide="1" id="MultiCarousel1" data-interval="1000">
							<div class="MultiCarousel-inner"
								style="transform: translateX(0px); width: 2710.4px;">
								<div class="item" style="width: 169.4px;">
									<div class="pad15">
										<span class="mailbox-attachment-icon has-img"><img
											src="/resources/img/Screenshot_14.png" alt="Attachment"></span>
									</div>
								</div>
								<div class="item" style="width: 169.4px;">
									<div class="pad15">
										<span class="mailbox-attachment-icon has-img"><img
											src="/resources/img/Screenshot_15.png" alt="Attachment"></span>
									</div>
								</div>
								<div class="item" style="width: 169.4px;">
									<div class="pad15">
										<span class="mailbox-attachment-icon has-img"><img
											src="/resources/img/Screenshot_16.png" alt="Attachment"></span>
									</div>
								</div>
								<div class="item" style="width: 169.4px;">
									<div class="pad15">
										<span class="mailbox-attachment-icon has-img"><img
											src="/resources/img/Screenshot_17.png" alt="Attachment"></span>
									</div>
								</div>
								<div class="item" style="width: 169.4px;">
									<div class="pad15">
										<span class="mailbox-attachment-icon has-img"><img
											src="/resources/img/Screenshot_18.png" alt="Attachment"></span>
									</div>
								</div>
								<div class="item" style="width: 169.4px;">
									<div class="pad15">
										<span class="mailbox-attachment-icon has-img"><img
											src="/resources/img/Screenshot_19.png" alt="Attachment"></span>
									</div>
								</div>
								<div class="item" style="width: 169.4px;">
									<div class="pad15">
										<span class="mailbox-attachment-icon has-img"><img
											src="/resources/img/Screenshot_20.png" alt="Attachment"></span>
									</div>
								</div>
								<div class="item" style="width: 169.4px;">
									<div class="pad15">
										<span class="mailbox-attachment-icon has-img"><img
											src="/resources/img/Screenshot_21.png" alt="Attachment"></span>
									</div>
								</div>
								<div class="item" style="width: 169.4px;">
									<div class="pad15">
										<span class="mailbox-attachment-icon has-img"><img
											src="/resources/img/Screenshot_22.png" alt="Attachment"></span>
									</div>
								</div>
							</div>
							<button class="btn btn-primary leftLst over">&lt;</button>
							<button class="btn btn-primary rightLst">&gt;</button>
						</div>

						<!-- /.col -->


						<div class="col-md-12 ">
							<div class="card">
								<div class="card-header p-2">
									<ul class="nav nav-pills">
										<!-- <li class="nav-item"><a class="nav-link active" href="#activity" data-toggle="tab">Activity</a></li> -->
										<li class="nav-item"><a class="nav-link" href="#settings"
											data-toggle="tab">Settings</a></li>
									</ul>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<div class="tab-content">
										<div class="active tab-pane" id="activity">


											<div class="tab-pane" id="settings">
												<form action="/band/create/${sessionScope.principal.userId}" method="POST" enctype="multipart/form-data"
													class="form-horizontal">
													
													<input type="hidden" name="userId" value="${sessionScope.principal.userId}" />
													<div class="form-group row">
														<label for="inputName" class="col-sm-2 col-form-label">밴드
															이름</label>
														<div class="col-sm-10">
															<input name="bandName" type="text" class="form-control"
																id="inputName" placeholder="밴드 이름">
														</div>
													</div>

													<div class="form-group row">
														<label for="inputExperience"
															class="col-sm-2 col-form-label">밴드 소개</label>
														<div class="col-sm-10">
															<textarea name="bandInfo" class="form-control"
																id="inputExperience" placeholder="밴드 소개"></textarea>
														</div>
													</div>
													<div class="form-group">
														<div class="btn btn-default btn-file ml-3">
															<i class="fas fa-paperclip"></i> Attachment <input
																type="file" name="bandFile" multiple="multiple" id="checkExtension" onclick="checkExtension()">
														</div>
														<p class="help-block">Max. 32MB</p>



														<div class="card-footer bg-white ml-3">
															<ul
																class="mailbox-attachments d-flex align-items-stretch clearfix">
																<li><span class="mailbox-attachment-icon"><i
																		class="far fa-file-pdf"></i></span>

																	<div class="mailbox-attachment-info">
																		<a href="#" class="mailbox-attachment-name"><i
																			class="fas fa-paperclip"></i> Sep2014-report.pdf</a> <span
																			class="mailbox-attachment-size clearfix mt-1">
																			<span>1,245 KB</span> <a href="#"
																			class="btn btn-default btn-sm float-right"><i
																				class="fas fa-cloud-download-alt"></i></a>
																		</span>
																	</div></li>
																<li><span class="mailbox-attachment-icon"><i
																		class="far fa-file-word"></i></span>

																	<div class="mailbox-attachment-info">
																		<a href="#" class="mailbox-attachment-name"><i
																			class="fas fa-paperclip"></i> App Description.docx</a> <span
																			class="mailbox-attachment-size clearfix mt-1">
																			<span>1,245 KB</span> <a href="#"
																			class="btn btn-default btn-sm float-right"><i
																				class="fas fa-cloud-download-alt"></i></a>
																		</span>
																	</div></li>
																<li><span class="mailbox-attachment-icon has-img"><img
																		src="/resources/dist/img/photo1.png" alt="Attachment"></span>

																	<div class="mailbox-attachment-info">
																		<a href="#" class="mailbox-attachment-name"><i
																			class="fas fa-camera"></i> photo1.png</a> <span
																			class="mailbox-attachment-size clearfix mt-1">
																			<span>2.67 MB</span> <a href="#"
																			class="btn btn-default btn-sm float-right"><i
																				class="fas fa-cloud-download-alt"></i></a>
																		</span>
																	</div></li>
																<li><span class="mailbox-attachment-icon has-img"><img
																		src="/resources/dist/img/photo2.png" alt="Attachment"></span>

																	<div class="mailbox-attachment-info">
																		<a href="#" class="mailbox-attachment-name"><i
																			class="fas fa-camera"></i> photo2.png</a> <span
																			class="mailbox-attachment-size clearfix mt-1">
																			<span>1.9 MB</span> <a href="#"
																			class="btn btn-default btn-sm float-right"><i
																				class="fas fa-cloud-download-alt"></i></a>
																		</span>
																	</div></li>
															</ul>
														</div>
													</div>
													<div class="form-group row">
														<div class="offset-sm-2 col-sm-4">
															<div class="checkbox">
																<label> <input type="checkbox" value="true" name="agree"> I agree
																	to the <a href="#">terms and conditions</a>
																</label>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<div class="offset-sm-2 col-sm-4">
															<button type="submit" class="btn btn-danger">완료</button>
														</div>
													</div>
												</form>
											</div>
											<!-- /.tab-pane -->
										</div>
										<!-- /.tab-content -->
									</div>
									<!-- /.card-body -->
								</div>
								<!-- /.nav-tabs-custom -->
							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.container-fluid -->
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b> 3.0.2
			</div>
			<strong>Copyright © 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
			<div class="p-3 control-sidebar-content">
				<h5>Customize AdminLTE</h5>
				<hr class="mb-2">
				<div class="mb-1">
					<input type="checkbox" value="1" class="mr-1"><span>No
						Navbar border</span>
				</div>
				<div class="mb-1">
					<input type="checkbox" value="1" class="mr-1"><span>Body
						small text</span>
				</div>
				<div class="mb-1">
					<input type="checkbox" value="1" class="mr-1"><span>Navbar
						small text</span>
				</div>
				<div class="mb-1">
					<input type="checkbox" value="1" class="mr-1"><span>Sidebar
						nav small text</span>
				</div>
				<div class="mb-1">
					<input type="checkbox" value="1" class="mr-1"><span>Footer
						small text</span>
				</div>
				<div class="mb-1">
					<input type="checkbox" value="1" class="mr-1"><span>Sidebar
						nav flat style</span>
				</div>
				<div class="mb-1">
					<input type="checkbox" value="1" class="mr-1"><span>Sidebar
						nav legacy style</span>
				</div>
				<div class="mb-1">
					<input type="checkbox" value="1" class="mr-1"><span>Sidebar
						nav compact</span>
				</div>
				<div class="mb-1">
					<input type="checkbox" value="1" class="mr-1"><span>Sidebar
						nav child indent</span>
				</div>
				<div class="mb-1">
					<input type="checkbox" value="1" class="mr-1"><span>Main
						Sidebar disable hover/focus auto expand</span>
				</div>
				<div class="mb-4">
					<input type="checkbox" value="1" class="mr-1"><span>Brand
						small text</span>
				</div>
				<h6>Navbar Variants</h6>
				<div class="d-flex">
					<div class="d-flex flex-wrap mb-3">
						<div class="bg-primary elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-secondary elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-info elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-success elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-danger elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-indigo elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-purple elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-pink elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-navy elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-lightblue elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-teal elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-cyan elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-dark elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-gray-dark elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-gray elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-light elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-warning elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-white elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
						<div class="bg-orange elevation-2"
							style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					</div>
				</div>
				<h6>Accent Color Variants</h6>
				<div class="d-flex"></div>
				<div class="d-flex flex-wrap mb-3">
					<div class="bg-primary elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-warning elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-info elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-danger elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-success elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-indigo elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-lightblue elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-navy elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-purple elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-fuchsia elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-pink elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-maroon elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-orange elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-lime elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-teal elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-olive elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
				</div>
				<h6>Dark Sidebar Variants</h6>
				<div class="d-flex"></div>
				<div class="d-flex flex-wrap mb-3">
					<div class="bg-primary elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-warning elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-info elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-danger elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-success elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-indigo elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-lightblue elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-navy elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-purple elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-fuchsia elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-pink elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-maroon elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-orange elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-lime elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-teal elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-olive elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
				</div>
				<h6>Light Sidebar Variants</h6>
				<div class="d-flex"></div>
				<div class="d-flex flex-wrap mb-3">
					<div class="bg-primary elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-warning elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-info elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-danger elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-success elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-indigo elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-lightblue elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-navy elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-purple elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-fuchsia elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-pink elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-maroon elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-orange elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-lime elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-teal elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-olive elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
				</div>
				<h6>Brand Logo Variants</h6>
				<div class="d-flex"></div>
				<div class="d-flex flex-wrap mb-3">
					<div class="bg-primary elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-secondary elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-info elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-success elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-danger elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-indigo elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-purple elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-pink elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-navy elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-lightblue elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-teal elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-cyan elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-dark elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-gray-dark elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-gray elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-light elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-warning elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-white elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<div class="bg-orange elevation-2"
						style="width: 40px; height: 20px; border-radius: 25px; margin-right: 10px; margin-bottom: 10px; opacity: 0.8; cursor: pointer;"></div>
					<a href="javascript:void(0)">clear</a>
				</div>
			</div>
		</aside>
		<!-- /.control-sidebar -->
		<div id="sidebar-overlay"></div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script src="/resources/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/resources/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="/resources/dist/js/demo.js"></script>
	





	<script type="text/javascript">
	var regex=new RegExp("(.*?)\.(exe/sh/zip/alz)$");
	var maxSize=5242880;
	
	function checkExtension(fileName, fileSize){
		alert('파일 사이즈 초과')

		if (fileSize>=maxSize) {
			alert('파일 사이즈 초과')
			return false;
			
		}if (regex.text(fileName)) {
			alert('해당 종류의 파일은 업로드 할 수 없습니다.')
			return false;
		}
		
	}
		$(document)
				.ready(
						function() {
							var itemsMainDiv = ('.MultiCarousel');
							var itemsDiv = ('.MultiCarousel-inner');
							var itemWidth = "";

							$('.leftLst, .rightLst').click(function() {
								var condition = $(this).hasClass("leftLst");
								if (condition)
									click(0, this);
								else
									click(1, this)
							});

							ResCarouselSize();

							$(window).resize(function() {
								ResCarouselSize();
							});

							//this function define the size of the items
							function ResCarouselSize() {
								var incno = 0;
								var dataItems = ("data-items");
								var itemClass = ('.item');
								var id = 0;
								var btnParentSb = '';
								var itemsSplit = '';
								var sampwidth = $(itemsMainDiv).width();
								var bodyWidth = $('body').width();
								$(itemsDiv)
										.each(
												function() {
													id = id + 1;
													var itemNumbers = $(this)
															.find(itemClass).length;
													btnParentSb = $(this)
															.parent().attr(
																	dataItems);
													itemsSplit = btnParentSb
															.split(',');
													$(this).parent().attr(
															"id",
															"MultiCarousel"
																	+ id);

													if (bodyWidth >= 1200) {
														incno = itemsSplit[3];
														itemWidth = sampwidth
																/ incno;
													} else if (bodyWidth >= 992) {
														incno = itemsSplit[2];
														itemWidth = sampwidth
																/ incno;
													} else if (bodyWidth >= 768) {
														incno = itemsSplit[1];
														itemWidth = sampwidth
																/ incno;
													} else {
														incno = itemsSplit[0];
														itemWidth = sampwidth
																/ incno;
													}
													$(this)
															.css(
																	{
																		'transform' : 'translateX(0px)',
																		'width' : itemWidth
																				* itemNumbers
																	});
													$(this)
															.find(itemClass)
															.each(
																	function() {
																		$(this)
																				.outerWidth(
																						itemWidth);
																	});

													$(".leftLst").addClass(
															"over");
													$(".rightLst").removeClass(
															"over");

												});
							}

							//this function used to move the items
							function ResCarousel(e, el, s) {
								var leftBtn = ('.leftLst');
								var rightBtn = ('.rightLst');
								var translateXval = '';
								var divStyle = $(el + ' ' + itemsDiv).css(
										'transform');
								var values = divStyle.match(/-?[\d\.]+/g);
								var xds = Math.abs(values[4]);
								if (e == 0) {
									translateXval = parseInt(xds)
											- parseInt(itemWidth * s);
									$(el + ' ' + rightBtn).removeClass("over");

									if (translateXval <= itemWidth / 2) {
										translateXval = 0;
										$(el + ' ' + leftBtn).addClass("over");
									}
								} else if (e == 1) {
									var itemsCondition = $(el).find(itemsDiv)
											.width()
											- $(el).width();
									translateXval = parseInt(xds)
											+ parseInt(itemWidth * s);
									$(el + ' ' + leftBtn).removeClass("over");

									if (translateXval >= itemsCondition
											- itemWidth / 2) {
										translateXval = itemsCondition;
										$(el + ' ' + rightBtn).addClass("over");
									}
								}
								$(el + ' ' + itemsDiv).css('transform',
										'translateX(' + -translateXval + 'px)');
							}

							//It is used to get some elements from btn
							function click(ell, ee) {
								var Parent = "#" + $(ee).parent().attr("id");
								var slide = $(Parent).attr("data-slide");
								ResCarousel(ell, Parent, slide);
							}

						});
	</script>


</body>
</html>