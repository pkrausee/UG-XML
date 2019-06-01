<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output indent="yes" encoding="UTF-8"/>
<xsl:template match="/">
<html>
<body>
<ul>
<xsl:for-each select="/lista/osoba">
<xsl:sort select="@plec" order="ascending" />
<xsl:sort select="wiek" order="descending" />
<xsl:choose>
<xsl:when test="@plec='k'">
<li>
<span  style="color:red;">
<xsl:value-of select="imie" /><xsl:text> </xsl:text><xsl:value-of select="nazwisko" />
</span>
</li>
</xsl:when>
<xsl:when test="@plec='m'">
<li>
<span  style="color:blue;">
<xsl:value-of select="imie" /><xsl:text> </xsl:text><xsl:value-of select="nazwisko" />
</span>
</li>
</xsl:when>
</xsl:choose>
</xsl:for-each>
</ul>
</body>
</html>
</xsl:template>
</xsl:stylesheet>