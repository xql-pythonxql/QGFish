<%--
  Created by IntelliJ IDEA.
  User: xql
  Date: 2020/5/1
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>find back</title>
    <style>
        body{
            background: url("img/catGirl.jpg") no-repeat;
            background-size: cover;
        }
        .all{
            border: grey 5px solid;
            width: 500px;
            height: 300px;
            margin-top: 200px;
            margin-left: 300px;
            background: rgba(255,255,255,0.8);
        }
        .all_head{
            width: 450px;
            height: 70px;
            box-sizing: border-box;
            padding-top: 10px;
            margin-top: 10px;
            margin-left: 20px;
            border-bottom: cornflowerblue 3px solid;
        }
        .all_head_1{
            color: cornflowerblue;
            font-size: 35px;
            float: left;
        }
        .all_head_2{
            color: grey;
            float: left;
            margin-top: 10px;
            margin-left: 5px;
            font-size: 25px;
        }
        .all_body{
            width: 450px;
            height: 180px;
            box-sizing: border-box;
            padding-left: 50px;
            margin-left: 20px;
            margin-top: 30px;

        //border: black solid 5px;
        }
        table{
            border-spacing: 10px;
        }
        .font1{
            font-size: 15px;
            text-align: center;
        }
        .font2{
            font-size: 25px;
            text-align: right;
        }
        .input{
            padding-left: 5px;
            background-color: transparent;
            width: 180px;
            height: 25px;
        }
        #td_btn{
            text-align: center;
        }
        #btn{
            width: 80px;
        }
    </style>
</head>
<body>
<div class="all">
    <div class="all_head">
        <div class="all_head_1">找回密码</div>
        <div class="all_head_2">find back</div>
    </div>
    <div class="all_body">
        <form action = "#" method="post" id="form" onsubmit="return submitCheck()">
            <table>
                <tr>
                    <td class="font2">账号</td>
                    <td colspan="2"><input id="usernameInput" class="input" type="text" placeholder="请输入账号" name="username"></td>
                </tr>
                <tr>
                    <td class="font2">邮箱</td>
                    <td><input class="input" id="emailInput" type="text" placeholder="请输入绑定的邮箱" name="email"></td>
                    <td><input type="button" value="发送验证码"></td>
                </tr>
                <tr>
                    <td class="font2">验证码</td>
                    <td colspan="2"><input class="input" type="text" name="checkCode"></td>
                </tr>
                <tr>
                    <td id="td_btn" colspan="3"><input id="btn" type="submit" value="确定"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
<script>
    var a = document.getElementById("a_register");
    a_register.href = "/Tomcat/register.html";

    function submitCheck() {
        var uText = document.getElementById("usernameInput").value;
        var eText = document.getElementById("emailInput").value;
        if (uText == null || uText == '' || uText == undefined) {
            window.alert("账号不能为空！");
            return false;
        } else if (eText == null || eText == '' || eText == undefined) {
            window.alert("邮箱不能为空！");
            return false;
        }
        return true;
    }
</script>
</html>
