<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:element name="artist">
			<xsl:attribute name="id"><xsl:value-of select="metadata/artist/@id" />
			</xsl:attribute>
			<xsl:attribute name="type"><xsl:value-of select="metadata/artist/@type" />
			</xsl:attribute>
			<xsl:element name="nomArtist">
				<xsl:value-of select="metadata/artist/name" />
			</xsl:element>
			<xsl:element name="sexe">
				<xsl:value-of select="metadata/artist/gender" />				
			</xsl:element>
		</xsl:element>
	</xsl:template>

</xsl:stylesheet>