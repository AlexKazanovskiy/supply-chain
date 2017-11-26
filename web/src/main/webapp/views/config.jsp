<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Network configuration</title>
    <script src="../scripts/vendors/requirejs/require.js"></script>
</head>
<body>
<script>
    require(['require', '../scripts/app'], function (require) {
        require(['require', 'jquery'], function(require, jquery) {
            require(['require', 'bootstrap'], function (require, bootstrap) {
                require(['require', 'css!bootcss'], function (require) {
                    require(['require', 'css!vectormapcss'], function (require) {
                            require(['require', 'vectormaplib'], function (require, jvm) {
                                require(['require', 'config/map'], function (require) {
                                    require(['require', 'config/main'], function (require, mainConfig) {
                                });
                            });
                        });
                    });
                });
            });
        });
    });
</script>
</body>
</html>
