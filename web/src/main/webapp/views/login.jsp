<%--
  Created by IntelliJ IDEA.
  User: stryzhov
  Date: 20/12/2014
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<spring:url var="authUrl" value="/j_spring_security_check"/>
<spring:url var="authUrl" value="/j_spring_security_check"/>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>Login</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
</head>
<body>
<security:authorize access="isAuthenticated()">
<div class="container" align="center">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/home">
                        <span class="glyphicon glyphicon-home">
                        </span> Home</a>
                    </li>
                    <li><a href="<c:url value='/j_spring_security_logout' />">
                        <span class="glyphicon glyphicon-log-out">
                        </span> Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="alert alert-info" role="alert" style="width: 50%">
        You are already logged in! Use navigation bar above to open home page or log out
    </div>
</security:authorize>
<div class="container" align="center">
  <h2><strong>Sign in</strong></h2>
  <div style="width: 40%">
    <c:if test="${param.containsKey('error')}">
      <div class="alert alert-danger" role="alert">
          Your login attempt was not successful, try again.<br />
          Reason: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
      </div>
    </c:if>

      <div class="alert alert-success"
           id="successDiv" role="alert"
           hidden="hidden" style="width: 80%"></div>

    <form class="form-horizontal"
          role="form"
          id="loginForm"
          method="post"
          action="${authUrl}">
      <div class="form-group">
        <label for="j_username"
               class="col-sm-2 control-label">Login</label>
        <div class="col-sm-10">
          <input type="text" class="form-control"
                 id="j_username"
                 name="j_username"
                 placeholder="Login">
        </div>
      </div>
      <div class="form-group">
        <label for="j_password"
               class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
          <input type="password" class="form-control"
                 id="j_password" placeholder="Password"
                 name="j_password">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-8 col-sm-4">
          <div class="checkbox">
            <label>
              <input type="checkbox"> Remember me
            </label>
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-9 col-sm-3">
            <button type="submit"
                    class="btn btn-default"
                    id="signInBtn"
                    <security:authorize access="isAuthenticated()">
                        disabled
                    </security:authorize>
                    > Sign in
            </button>
        </div>
      </div>
    </form>
      <security:authorize access="isAnonymous()">
          <p class="lead" align="right">
              Don't have an account? Click
              <a id="signUp" style="cursor: pointer" data-toggle="modal" data-target="#myModal">here</a> to sign up.
          </p>
      </security:authorize>
  </div>
</div>
<!----------------------Modal for user form -->
<div class="modal fade" id="myModal"
     tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel"
     aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
          <span aria-hidden="true">&times;</span>
          <span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Add new user</h4>
      </div>
      <div class="modal-body" align="center">

          <div class="alert alert-danger"
               id="errorDiv" role="alert"
               style="width: 80%" hidden="hidden"></div>

        <form class="form-horizontal" role="form" id="userForm">
          <!------------------------------------first form row----------------------------->
          <div class="row">
            <!------------------first form column-------------------------->
            <div class="col-sm-5" align="left">
              <!--login input-->
              <div class="form-group has-feedback">
                <label class="control-label col-sm-6"
                       for="login">Login:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control"
                         id="login" placeholder="Enter login"
                         title="Only letters and numbers allowed
                               Length between 3 and 15 characters">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                </div>
              </div>
              <!--email input-->
              <div class="form-group has-feedback">
                <label class="control-label col-sm-6"
                       for="email">Email:</label>
                <div class="col-sm-6">
                  <input type="email" class="form-control"
                         id="email" placeholder="Enter email"
                         title="Please enter a VALID email">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                </div>
              </div>
              <!--password input-->
              <div class="form-group has-feedback">
                <label class="control-label col-sm-6"
                       for="password">Password:</label>
                <div class="col-sm-6">
                  <input type="password" class="form-control"
                         id="password" placeholder="Enter password"
                         title="Password must be at least 3 characters long">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                </div>
              </div>
              <!--password confirm input-->
              <div class="form-group has-feedback">
                <label class="control-label col-sm-6"
                       for="passwordAgain">Password again:</label>
                <div class="col-sm-6">
                  <input type="password" class="form-control"
                         id="passwordAgain" placeholder="Confirm password"
                         title="Please confirm your password">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                </div>
              </div>
            </div>
            <!-----------------------second form column-------------------------->
            <div class="col-sm-5" align="left">
              <!--first name input-->
              <div class="form-group has-feedback">
                <label class="control-label col-sm-6"
                       for="firstName">First name:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control"
                         id="firstName" placeholder="Enter first name"
                         title="Only letters, dash and apostrophe allowed.
                               Only letters at the beginning/end">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                </div>
              </div>
              <!--last name input-->
              <div class="form-group has-feedback">
                <label class="control-label col-sm-6"
                       for="lastName">Last name:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control"
                         id="lastName" placeholder="Enter last name"
                         title="Only letters, dash and apostrophe allowed.
                               Only letters at the beginning/end">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                </div>
              </div>
              <!--birthday input-->
              <div class="form-group has-feedback">
                <label class="control-label col-sm-6"
                       for="datepicker">Birthday:</label>
                <div class="col-sm-6">
                  <input type="text" class="form-control"
                         id="datepicker" placeholder="Enter birth date"
                         title="Specify user's birth date" readonly
                         style="cursor: pointer">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                </div>
              </div>
            </div>
            <div class="col-sm-12">
              <div class="g-recaptcha" data-sitekey="6LeDNP4SAAAAAMkLZAZW_CEJ0M-VMS1DEcpq3DwX"></div>
            </div>
          </div>
          <h4>Verify captcha <small>Just in case you are a robot</small></h4>
          <div class="row">
            <div class="col-sm-12">
              <div class="g-recaptcha" data-sitekey="6LeDNP4SAAAAAMkLZAZW_CEJ0M-VMS1DEcpq3DwX"></div>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button"
                class="btn btn-success"
                id="signUpBtn"
                data-loading-text="Adding..."
                data-complete-text="Added!"
                autocomplete="off">Submit</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>

      </div>
    </div>
  </div>
</div>
<script src="../scripts/vendors/jquery/dist/jquery.js"></script>
<script src="../scripts/vendors/underscore/underscore.js"></script>
<script src="../scripts/vendors/backbone/backbone.js"></script>
<script src="../scripts/vendors/backbone-associations/backbone-associations.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="../scripts/models.js"></script>
<script src="../scripts/validator.js"></script>
<script src="../scripts/login.js"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</body>
</html>
