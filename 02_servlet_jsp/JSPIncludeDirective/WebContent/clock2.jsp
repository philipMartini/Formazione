<table style="background-color: black;">
	<tr>
		<td style="background-color: black;">
			<p class="big" style="color: cyan;">
			<%java.util.Locale locale = request.getLocale();
				java.text.DateFormat dateFormat = 
						java.text.DateFormat.getDateTimeInstance(
								java.text.DateFormat.LONG,
								java.text.DateFormat.LONG, locale);
				
			
			%>
			<%= dateFormat.format(new java.util.Date() ) %>
			</p>
		</td>
	</tr>
</table>