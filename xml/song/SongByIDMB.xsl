<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:element name="Song">
			<xsl:attribute name="id"><xsl:value-of
						select="metadata/recording/@id" /></xsl:attribute>
			<xsl:element name="titreSong">
				<xsl:value-of select="metadata/recording/title"></xsl:value-of>
			</xsl:element>
			<xsl:element name="duree">
				<xsl:value-of select="metadata/recording/length"></xsl:value-of>
			</xsl:element>
		</xsl:element>
	</xsl:template>		
</xsl:stylesheet>
