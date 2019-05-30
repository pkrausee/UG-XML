<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output indent="yes" encoding="UTF-8"/>
<xsl:template match="/">
<html>
<body>
<ol>
<xsl:for-each select="/lista/osoba">
<xsl:choose>
<xsl:when test="grupa/text()=1">
<li>
<span  style="color:red;">
<xsl:value-of select="imie" /><xsl:text> </xsl:text><xsl:value-of select="nazwisko" />
</span>
</li>
</xsl:when>
<xsl:when test="grupa/text()=2">
<li>
<span  style="color:blue;">
<xsl:value-of select="imie" /><xsl:text> </xsl:text><xsl:value-of select="nazwisko" />
</span>
</li>
</xsl:when>
<xsl:when test="grupa/text()=3">
<li>
<span  style="color:green;">
<xsl:value-of select="imie" /><xsl:text> </xsl:text><xsl:value-of select="nazwisko" />
</span>
</li>
</xsl:when>
</xsl:choose>

</xsl:for-each>
</ol>
</body>
</html>
</xsl:template>
</xsl:stylesheet>