<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output indent="yes" encoding="UTF-8"/>
<xsl:template match="/">
<html>
<link rel="stylesheet" type="text/css" href="zad6.css" />
<body>
<h3>Grupa 1</h3>
<table>
<xsl:for-each select="/lista/osoba[grupa/text()=1]">
<tr><td><xsl:value-of select="imie" /><xsl:text> </xsl:text><xsl:value-of select="nazwisko" /></td></tr>
</xsl:for-each>
</table>
<h3>Grupa 2</h3>
<table>
<xsl:for-each select="/lista/osoba[grupa/text()=2]">
<tr><td><xsl:value-of select="imie" /><xsl:text> </xsl:text><xsl:value-of select="nazwisko" /></td></tr>
</xsl:for-each>
</table>
<h3>Grupa 3</h3>
<table>
<xsl:for-each select="/lista/osoba[grupa/text()=3]">
<tr><td><xsl:value-of select="imie" /><xsl:text> </xsl:text><xsl:value-of select="nazwisko" /></td></tr>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>