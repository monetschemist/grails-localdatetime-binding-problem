<div class="row mb-2">
	<!-- views/_fields/default/_wrapper.gsp -->
	<div class="col-sm-1">
		<g:if test="${required}">
		<label class="control-label text-danger float-right" for="${property}">${label} *</label>
		</g:if>
		<g:else>
		<label class="control-label text-secondary float-right" for="${property}">${label}</label>
		</g:else>
	</div>
	<div class="col-sm-6">
		<g:if test="${type.toString() == 'boolean'}">
		<!-- it is a boolean -->
		<f:widget class="form-check-input" bean="${bean}" property="${property}" />
		</g:if>
		<g:else>
		<!-- it is either required or not -->
		<g:if test="${required}">
		<!-- it is required -->
		<f:widget class="form-control border border-danger" bean="${bean}" property="${property}" />
		</g:if>
		<g:else>
		<!-- it is not required -->
		<f:widget class="form-control" bean="${bean}" property="${property}" />
		</g:else>
		</g:else>
	</div>
</div>
