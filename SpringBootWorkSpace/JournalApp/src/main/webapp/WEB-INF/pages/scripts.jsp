<!-- jQuery 3 -->
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<!-- Morris.js charts -->
<script src="<c:url value="/resources/js/raphael.min.js"/>"></script>
<script src="<c:url value="/resources/js/morris.min.js"/>"></script>
<!-- Sparkline -->
<script src="<c:url value="/resources/js/jquery.sparkline.min.js"/>"></script>
<!-- jvectormap -->
<script src="<c:url value="/resources/js/jquery-jvectormap-1.2.2.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-jvectormap-world-mill-en.js"/>"></script>
<!-- jQuery Knob Chart -->
<script src="<c:url value="/resources/js/jquery.knob.min.js"/>"></script>
<!-- daterangepicker -->
<script src="<c:url value="/resources/js/moment.min.js"/>"></script>
<script src="<c:url value="/resources/js/daterangepicker.js"/>"></script>
<!-- datepicker -->
<script src="<c:url value="/resources/js/bootstrap-datepicker.min.js"/>"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="<c:url value="/resources/js/bootstrap3-wysihtml5.all.min.js"/>"></script>
<!-- Slimscroll -->
<script src="<c:url value="/resources/js/jquery.slimscroll.min.js"/>"></script>
<!-- FastClick -->
<script src="<c:url value="/resources/js/fastclick.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/resources/js/adminlte.min.js"/>"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<!-- <script src="dist/js/pages/dashboard.js"></script> -->
<!-- AdminLTE for demo purposes -->
<!-- <script src="dist/js/demo.js"></script> -->
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>