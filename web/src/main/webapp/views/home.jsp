<%--
  Created by IntelliJ IDEA.
  User: stryzhov
  Date: 20/12/2014
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>Home</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <link rel="stylesheet" href="<spring:url value='/css/additional.css'/>">
</head>
<body>

<sec:authorize access="hasRole('user')">
  <div class="container" align="center">
    <h1>
      Hello, ${CURRENT_USER.firstName} ${CURRENT_USER.lastName}
    </h1>
    <h3>
      Click
      <a href="<c:url value='/j_spring_security_logout' />">here</a>
      to logout
    </h3>
  </div>
</sec:authorize>
<sec:authorize access="hasRole('admin')">
    <div class="container" align="center">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <strong class="navbar-brand ">
                            ${CURRENT_USER.firstName} ${CURRENT_USER.lastName}</strong>
                        </li>
                        <li class="active"><a href="#">
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
        <!--messages-->
        <div class="alert alert-success" role="alert" hidden="hidden" style="width: 80%"></div>
        <div class="alert alert-danger" role="alert" hidden="hidden" style="width: 80%"></div>

        <div class="row" id="usersListHeader">
            <div class="col-xs-1">
                <button id="btnModal" type="button" class="btn btn-info"
                        data-toggle="modal" data-target="#myModal">
                    <span class="glyphicon glyphicon-plus"></span>
                    Add user
                </button>
            </div>
            <div class="col-xs-11">
                <h2>Users list <small>Click on user to expand end edit data</small></h2>
            </div>
        </div>
        <script type="text/template" id="usersTable">
            <div class="row header borders">
                <div class="col-xs-2">Login</div>
                <div class="col-xs-2">First name</div>
                <div class="col-xs-2">Last name</div>
                <div class="col-xs-2">Birth date</div>
                <div class="col-xs-2">Role</div>
                <div class="col-xs-2">Remove</div>
            </div>
        </script>
        <!--user info rows-->
        <script type="text/template" id="infoShort">
            <div class="col-xs-2">{{ login }}</div>
            <div class="col-xs-2">{{ firstName}}</div>
            <div class="col-xs-2">{{ lastName }}</div>
            <div class="col-xs-2">{{ birthday }}</div>
            <div class="col-xs-2">{{ role.name }}</div>
            <div class="col-xs-2">
                <a id="remove" style="cursor: pointer">
                    <span class="glyphicon glyphicon-remove"></span>
                    Remove</a>
            </div>
        </script>
    </div>

    <script type="text/template" id="infoExpanded">
        <!--form-->
        <h3>Edit user data</h3>

        <div class="col-xs-offset-6 col-xs-6">
            <button class="btn btn-success"
                    id="updateButton"
                    data-loading-text="Updating..."
                    data-complete-text="Updated!">
                Update user
            </button>
        </div>
    </script>

    <script type="text/template" id="userForm">
            <!------------------------------------first form row----------------------------->
            <div class="row">
                <!------------------first form column-------------------------->
                <div class="col-xs-offset-1 col-xs-5" >
                    <!--login input-->
                    <div class="form-group has-feedback">
                        <div class="col-xs-6" align="right">
                            <label class="control-label"
                                   for="login">Login:</label>
                        </div>

                        <div class="col-xs-6">
                            <input type="text" class="form-control"
                                   id="login" placeholder="Enter login"
                                   title="Only letters and numbers allowed
                                   Length between 3 and 15 characters"
                                   value="{{login}}">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                        </div>
                    </div>
                    <!--email input-->
                    <div class="form-group has-feedback">
                        <div class="col-xs-6" align="right">
                            <label class="control-label"
                                   for="email">Email:</label>
                        </div>

                        <div class="col-xs-6">
                            <input type="email" class="form-control"
                                   id="email" placeholder="Enter email"
                                   title="Please enter a VALID email"
                                   value="{{email}}">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                        </div>
                    </div>
                    <!--password input-->
                    <div class="form-group has-feedback">
                        <div class="col-xs-6" align="right">
                            <label class="control-label"
                                   for="password">Password:</label>
                        </div>

                        <div class="col-xs-6">
                            <input type="password" class="form-control"
                                   id="password" placeholder="Enter password"
                                   title="Password must be at least 3 characters long"
                                   value="{{password}}">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                        </div>
                    </div>
                    <!--password confirm input-->
                    <div class="form-group has-feedback">
                        <div class="col-xs-6" align="right">
                            <label class="control-label"
                                   for="passwordAgain">Password again:</label>
                        </div>

                        <div class="col-xs-6">
                            <input type="password" class="form-control"
                                   id="passwordAgain" placeholder="Confirm password"
                                   title="Please confirm your password"
                                   value="{{password}}">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                        </div>
                    </div>
                </div>
                <!-----------------------second form column-------------------------->
                <div class="col-xs-5">
                    <!--first name input-->
                    <div class="form-group has-feedback">
                        <div class="col-xs-6">
                            <input type="text" class="form-control"
                                   id="firstName" placeholder="Enter first name"
                                   title="Only letters, dash and apostrophe allowed.
                                   Only letters at the beginning/end"
                                   value="{{firstName}}">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                        </div>
                        <div class="col-xs-6" align="left">
                            <label class="control-label"
                                   for="firstName">:First name</label>
                        </div>
                    </div>
                    <!--last name input-->
                    <div class="form-group has-feedback">
                        <div class="col-xs-6">
                            <input type="text" class="form-control"
                                   id="lastName" placeholder="Enter last name"
                                   title="Only letters, dash and apostrophe allowed.
                                   Only letters at the beginning/end"
                                   value="{{lastName}}">
                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                        </div>
                        <div class="col-xs-6" align="left">
                            <label class="control-label"
                                   for="lastName">:Last name</label>
                        </div>
                    </div>
                    <!--birthday input-->
                    <div class="form-group has-feedback">
                        <div class="col-xs-6">
                            <input type="text" class="form-control"
                                   id="datepicker" placeholder="Enter birth date"
                                   title="Specify user's birth date"
                                   style="cursor: pointer"
                                   value="{{birthday}}"
                                    readonly>

                        <span class="glyphicon form-control-feedback"
                              aria-hidden="true"></span>
                        </div>
                        <div class="col-xs-6" align="left">
                            <label class="control-label"
                                   for="datepicker">:Birthday</label>
                        </div>
                    </div>
                    <!--role select-->
                    <div class="form-group">
                        <div class="col-xs-6" id="roleSelect"></div>
                        <div class="col-xs-6" align="left">
                            <label class="control-label">:Role</label>
                        </div>
                    </div>
                </div>
            </div>
    </script>

    <!----------------------Modal for user form -->
    <div class="modal fade" id="myModal">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">Sign up</h4>
                </div>
                <div class="modal-body" align="center">

                </div>
                <div class="modal-footer">
                    <button type="button"
                            class="btn btn-success"
                            id="registerButton"
                            data-loading-text="Processing..."
                            data-complete-text="Successful!"
                            autocomplete="off">Submit</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</sec:authorize>
<script src="../scripts/vendors/jquery/dist/jquery.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<sec:authorize access="hasRole('admin')">
    <script src="../scripts/vendors/underscore/underscore.js"></script>
    <script src="../scripts/vendors/backbone/backbone.js"></script>
    <script src="../scripts/vendors/backbone-associations/backbone-associations.js"></script>
    <script src="../scripts/models.js"></script>
    <script src="../scripts/collections.js"></script>
    <script src="../scripts/views.js"></script>
    <script src="../scripts/validator.js"></script>
</sec:authorize>
</body>
</html>