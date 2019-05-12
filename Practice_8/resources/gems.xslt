<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="/">
		<html>
			<head>
				<style type="text/css">
					table.tfmt {
					border: 1px ;
					}

					td.colfmt {
					border: 1px ;
					background-color: white;
					color: black;
					text-align:right;
					}

					th {
					background-color: #2E9AFE;
					color: white;
					}
				</style>
			</head>

			<body>
				<table class="tfmt">
					<tr>
						<th style="width:250px">Name</th>
						<th style="width:350px">Preciousness</th>
						<th style="width:250px">Origin</th>
						<th style="width:250px">Color</th>
						<th style="width:250px">Transparency</th>
						<th style="width:250px">Facet</th>
					</tr>

					<xsl:for-each select="gems/gem">
						<tr>
							<td class="colfmt">
								<xsl:value-of select="name" />
							</td>
							<td class="colfmt">
								<xsl:value-of select="preciousness" />
							</td>

							<td class="colfmt">
								<xsl:value-of select="origin" />
							</td>
                            <xsl:for-each select="visual_parameters">
							    <td class="colfmt">
								    <xsl:value-of select="color" />
							    </td>
							    <td class="colfmt">
								    <xsl:value-of select="transparency" />
							    </td>
							    <td class="colfmt">
								    <xsl:value-of select="facet" />
							    </td>
					        </xsl:for-each>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
