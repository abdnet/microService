<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:element name="album">
			<xsl:attribute name="id"><xsl:value-of select="metadata/release/@id" /></xsl:attribute>
			<xsl:element name="titreAlbum">
				<xsl:value-of select="metadata/release/title" />
			</xsl:element>
			<xsl:element name="statusAlbum">
				<xsl:value-of select="metadata/release/status" />
			</xsl:element>
			<xsl:element name="langageAlbum">
				<xsl:value-of select="metadata/release/text-representation/language" />
			</xsl:element>	
			<xsl:element name="paysAlbum">
				<xsl:value-of select="metadata/release/country" />
			</xsl:element>
			<xsl:element name="dateAlbum">
				<xsl:value-of select="metadata/release/date" />
			</xsl:element>											
		</xsl:element>
	</xsl:template>

</xsl:stylesheet>