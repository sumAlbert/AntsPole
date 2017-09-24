<%--
  Created by IntelliJ IDEA.
  User: 98267
  Date: 2017/9/19
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>AntsPole</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="./css/index.css">
</head>
<body>
<div class="body">
  <div class="header">蚂蚁爬竿问题演示</div>
  <div class="main">
    <div class="main-content">
      <div class="panel1">
        <div class="panel1-line">
          <div class="ant-forward">P.S. 任意蚂蚁之间的距离必须为所有速度的最小公倍数的整数倍</div>
          <div class="panel1-line-icon"></div>
          <div class="panel1-line-item">长度</div>
          <div class="panel1-line-input-box">
            <input class="panel1-line-input" placeholder="10" id="pole-len">
          </div>
          <div class="panel1-line-item">cm</div>
          <div class="run-button">运行</div>
        </div>
        <div class="panel1-line">
          <div class="panel1-line-icon panel1-line-ant-name">蚂蚁1</div>
          <div class="panel1-line-item">速度</div>
          <div class="panel1-line-input-box">
            <input class="panel1-line-input ant-speed" placeholder="1">
          </div>
          <div class="panel1-line-item">cm/s</div>
          <div class="panel1-line-item">方向</div>
          <div class="panel1-line-switch-box">
            <div class="panel1-line-switch-item">
              <div class="panel1-line-switched">均可</div>
              <div class="panel1-line-bottom-arrow"></div>
            </div>
            <div class="panel1-line-switch-items-hidden">
              <div class="panel1-line-switch-item-hidden switch-left" >左</div>
              <div class="panel1-line-switch-item-hidden switch-right">右</div>
              <div class="panel1-line-switch-item-hidden switch-both">均可</div>
            </div>
          </div>
          <div class="panel1-line-item">&nbsp;&nbsp;</div>
          <div class="panel1-line-item">左端距离</div>
          <div class="panel1-line-input-box">
            <input class="panel1-line-input ant-dist" placeholder="1">
          </div>
          <div class="panel1-line-item">cm</div>
          <div class="panel1-line-add" id="add-ant"></div>
        </div>
        <div class="panel1-line">
          <div class="panel1-line-icon panel1-line-ant-name">蚂蚁2</div>
          <div class="panel1-line-item">速度</div>
          <div class="panel1-line-input-box">
            <input class="panel1-line-input ant-speed" placeholder="1">
          </div>
          <div class="panel1-line-item">cm/s</div>
          <div class="panel1-line-item">方向</div>
          <div class="panel1-line-switch-box">
            <div class="panel1-line-switch-item">
              <div class="panel1-line-switched">均可</div>
              <div class="panel1-line-bottom-arrow"></div>
            </div>
            <div class="panel1-line-switch-items-hidden">
              <div class="panel1-line-switch-item-hidden switch-left">左</div>
              <div class="panel1-line-switch-item-hidden switch-right">右</div>
              <div class="panel1-line-switch-item-hidden switch-both">均可</div>
            </div>
          </div>
          <div class="panel1-line-item">&nbsp;&nbsp;</div>
          <div class="panel1-line-item">左端距离</div>
          <div class="panel1-line-input-box">
            <input class="panel1-line-input ant-dist" placeholder="1">
          </div>
          <div class="panel1-line-item">cm</div>
          <div class="panel1-line-close"></div>
        </div>
      </div>
      <div class="panel2">
        <div class="result-part">
          <div class="result-part-line">
            <div class="result-part-line-hidden-info"></div>
            <div class="result-part-line-name">
              <div class="result-part-line-name-kind"></div>
              <div class="result-part-line-name-extra"></div>
            </div>
            <div class="result-part-line-items">
              <div class="result-part-line-item">
                <div class="result-part-line-item-name"></div>
                <div class="result-part-line-item-content"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="hidden-content"></div>
  </div>
</div>
</body>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/index.js"></script>
</html>
