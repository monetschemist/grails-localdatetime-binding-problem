<div class="row mb-2">
	<!-- views/_fields/default/_displayWrapper.gsp -->
	<!-- displayStyle "${displayStyle}" -->
	<!-- <g:if test="${displayStyle != 'table'}"> -->
	<!-- <div class="col-sm-1"> -->
	<!-- 	<label class="control-label text-secondary float-right" for="${property}">${label}</label> -->
	<!-- </div> -->
	<!-- </g:if> -->
	<div class="col-sm-6">
		<!-- type.toString() ${type.toString()} -->
		<!-- property.getClass() ${property.getClass()} -->
        <g:if test="${type.toString() == 'boolean'}">
		<!-- a boolean -->
        <f:displayWidget class="form-check-input" bean="${bean}" property="${property}" />
		</g:if>
		<g:else>
		<!-- not a boolean -->
        <f:displayWidget class="form-control" bean="${bean}" property="${property}" />
		</g:else>
	</div>
</div>
