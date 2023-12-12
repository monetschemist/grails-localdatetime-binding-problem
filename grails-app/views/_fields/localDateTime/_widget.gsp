<!-- views/_fields/localDate/_widget.gsp -->
<g:if test="${required}">
<g:field class="form-control border border-danger" type="datetime-local" name="${property}" value="${value}" required="" />
</g:if>
<g:else>
<g:field class="form-control" type="datetime-local" name="${property}" value="${value}" />
</g:else>
