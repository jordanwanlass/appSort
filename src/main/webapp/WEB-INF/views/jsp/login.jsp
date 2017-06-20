<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<style type="text/css">
    body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #eee;
    }

    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }
    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }
    .form-signin .checkbox {
        font-weight: normal;
    }
    .form-signin .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
    }
    .form-signin .form-control:focus {
        z-index: 2;
    }
    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>

<div class="container">
    <div class="panel panel-default col-sm-6 col-sm-offset-3">
        <div class="panel-body">
            <c:url value="/login" var="loginUrl"/>
            <c:choose>
                <c:when test="${param.logout == null}">
                    <form class="form-signin" role="form" action="${loginUrl}" method="post">
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger" role="alert">
                                Invalid username and/or password.
                            </div>
                        </c:if>
                        <h2 class="form-signin-heading">Please, Sign In</h2>
                        <input type="text" name="username" class="form-control" placeholder="Username" required="" autofocus="">
                        <input type="password" name="password" class="form-control" placeholder="Password" required="">
                        <input type="hidden"
                               name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>
                        <div>
                            Don't have an account?<a href="createAccountForm"> Create one here!</a>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-success" role="alert" style="text-align: center;">
                        You have been successfully logged out!
                    </div>
                    <script>
                        setTimeout("logout();", 3000);
                    </script>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div><!-- /container -->
<script type="text/javascript">
    ${timeout}
    function refreshPage() {
        alert("Your Session has expired.  The page will now reload to prevent errors.");
        location.reload();
    }

    function logout() {
        window.location.href = 'exterior';
    }
</script>
