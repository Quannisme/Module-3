<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <style>
        body {
            font-family: Arial, Tahoma;
            font-size: 12px;
        }

        #main {
            width: auto;
            height: auto;
            padding: 0;
            margin-left: auto;
            margin-right: auto;
        }

        #head {
            height: 100px;
            background-color: #F5F5F5;
            border: 1px solid #CDCDCD;
            margin-bottom: 5px;
        }

        #head-link {
            height: 30px;
            line-height: 30px;
            padding-left: 10px;
            padding-right: 10px;
            border: 1px solid #CDCDCD;
            background-color: #F5F5F5;
            margin-bottom: 5px;
            clear: both;
        }

        #left {
            width: 150px;
            min-height: 500px;
            border: 1px solid #CDCDCD;
            float: left;
            background-color: #004C00;
            margin-bottom: 5px;
        }

        #content {
            width: 80%;
            min-height: 500px;
            border: 1px solid #CDCDCD;
            float: left;
            margin-left: 5px;
            margin-right: 5px;
            margin-bottom: 5px;
            text-align: center;
        }

        /*#right{*/
        /*    width: 234px;*/
        /*    min-height: 400px;*/
        /*    border: 1px solid #CDCDCD;*/
        /*    float:right;*/
        /*    margin-bottom: 5px;*/
        /*}*/

        #footer {
            height: 10%;
            clear: both;
            border: 1px solid #CDCDCD;
            background-color: #F8F8FF;
        }
    </style>
</head>
<body>


<div id="main">
    <div id="head">
    </div>
    <div id="head-link">
    </div>
    <div id="left">
    </div>
</div>
<div id="content">
    <form method="post" action="/user?action=delete">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">ID</th>
                <th scope="col">Full Name</th>
                <th scope="col">Code</th>
                <th scope="col">birth</th>
                <th scope="col">start date</th>
                <th scope="col">roleName</th>
                <th scope="col" colspan="2">action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userRoleList}" var="list" varStatus="index">
                <tr>
                    <td>${index.count}</td>
                    <td>${list.getUser().getIdUser()}</td>
                    <td>${list.getUser().getFullName()}</td>
                    <td>${list.getUser().getCode()}</td>
                    <td>${list.getUser().getBirth()}</td>
                    <td>${list.getUser().getStartDate()}</td>
                    <td>${list.getRole().getRoleName()}</td>
                    <td><button><a href="/user?action=edit&id=${list.getUser().getIdUser()}" ></a>Edit</button></td>
                    <td><input type="checkbox" name="idRemove" value="${list.getUser().getIdUser()}">
                </tr>
            </c:forEach>
            </tr>
            </tbody>
        </table>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            Remove
        </button>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Bạn có xác nhận xóa
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" formtarget="_blank">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </form>

</div>
<%--    <div id="right">--%>
<%--    </div>--%>
<div id="footer">
</div>
</div>
<!-- Button trigger modal -->


</body>
</html>
