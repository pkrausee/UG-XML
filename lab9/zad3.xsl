<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output indent="yes" encoding="UTF-8"/>
    <xsl:template match="/">
        <lista>
            <xsl:for-each select="lista/osoba">
                <xsl:element name="osoba">
                    <imie>
                        <xsl:value-of select="imie/text()" />
                    </imie>
                    <nazwisko>
                        <xsl:value-of select="nazwisko/text()" />
                    </nazwisko>
                    <plec>
                        <xsl:if test="@plec = 'm' ">
                            <xsl:text>Mezczyzna</xsl:text>
                        </xsl:if>
                        <xsl:if test="@plec = 'k' ">
                            <xsl:text>Kobieta</xsl:text>
                        </xsl:if>
                    </plec>
                </xsl:element>
            </xsl:for-each>
        </lista>
    </xsl:template>
</xsl:stylesheet>