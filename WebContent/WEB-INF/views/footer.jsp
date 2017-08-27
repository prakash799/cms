<style>
 html #footer {
   position:absolute;
   top:expression((0-(footer.offsetHeight)+(document.documentElement.clientHeight ? document.documentElement.clientHeight : document.body.clientHeight)+(ignoreMe = document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop))+'px');
   z-index: 0;
}

</style>

<div id="footer" class="footer navbar-fixed-bottom " style="border-top:none  1px;border-color: #3B5998;margin-left:15%;margin-right: 15%; background:none; ">
      <div class="">
		<p class="text-center"><br><font style="color:black;">CMS Application Copyright © 2017</font></p>
      </div>
  </div>