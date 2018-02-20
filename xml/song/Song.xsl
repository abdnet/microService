<?xml version="1.0" ?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:nmd="http://musicbrainz.org/ns/mmd-2.0#">
	<xsl:output method="xml" version="1.0" />
	<xsl:template match="/">
		<xsl:element name="songs">
			<xsl:for-each select="metadata/recording-list/recording">
				<xsl:element name="song">
					<xsl:attribute name="last_id"> <xsl:value-of
						select="@id" /> </xsl:attribute>
					<xsl:element name="titleSong">
						<xsl:value-of select="title" />
					</xsl:element>
					<xsl:element name="duree">
						<xsl:value-of select="length" />
					</xsl:element>
					<xsl:element name="artist">
						<xsl:value-of select="artist-credit/name-credit/artist/@id" />
						
					</xsl:element>
					<xsl:element name="albums">
					<xsl:attribute name="annee"> <xsl:value-of
						select="release-list/release[1]/date" /> </xsl:attribute>
						<xsl:value-of select="release-list/release[1]/@id" />
									</xsl:element>
					
				</xsl:element>
			</xsl:for-each>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>