<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output indent="yes" encoding="UTF-8"/>
<xsl:template match="/">
<html>
<body>
<table>
<xsl:for-each select="/lista/osoba">
<tr><td><xsl:value-of select="imie" /><xsl:text> </xsl:text><b><xsl:value-of select="nazwisko" /></b>
<xsl:text> </xsl:text><u><xsl:text>Grupa</xsl:text></u><xsl:text> </xsl:text><i><xsl:value-of select="grupa" /></i>
</td></tr>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>