<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output indent="yes" encoding="UTF-8"/>
<xsl:template match="/">
<html>
<body>
<table>
<tr><td><b><xsl:text>Ilosc osob: </xsl:text></b><xsl:value-of select="count(/lista/osoba)" /></td></tr>
<tr><td><b><xsl:text>Ilosc osob grupa 1: </xsl:text></b><xsl:value-of select="count(/lista/osoba[grupa/text()=1])" /></td></tr>
<tr><td><b><xsl:text>Ilosc osob grupa 2: </xsl:text></b><xsl:value-of select="count(/lista/osoba[grupa/text()=2])" /></td></tr>
<tr><td><b><xsl:text>Ilosc osob grupa 3: </xsl:text></b><xsl:value-of select="count(/lista/osoba[grupa/text()=3])" /></td></tr>
<tr><td><b><xsl:text>Ilosc kobiet: </xsl:text></b><xsl:value-of select="count(/lista/osoba[@plec='k'])" /></td></tr>
<tr><td><b><xsl:text>Ilosc mezczyzn: </xsl:text></b><xsl:value-of select="count(/lista/osoba[@plec='m'])" /></td></tr>
<tr><td><b><xsl:text>Srednia wieku : </xsl:text></b><xsl:value-of select="round(sum(/lista/osoba/wiek/text()) div count(/lista/osoba) * 100) div 100" /></td></tr>
<tr><td><b><xsl:text>Srednia wieku grupa 1: </xsl:text></b><xsl:value-of select="round(sum(/lista/osoba[grupa=1]/wiek) div count(/lista/osoba[grupa=1]) * 100) div 100" /></td></tr>
<tr><td><b><xsl:text>Srednia wieku grupa 2: </xsl:text></b><xsl:value-of select="round(sum(/lista/osoba[grupa=2]/wiek) div count(/lista/osoba[grupa=2]) * 100) div 100" /></td></tr>
<tr><td><b><xsl:text>Srednia wieku grupa 3: </xsl:text></b><xsl:value-of select="round(sum(/lista/osoba[grupa=3]/wiek) div count(/lista/osoba[grupa=3]) * 100) div 100" /></td></tr>
<tr><td><b><xsl:text>Srednia wieku kobiet: </xsl:text></b><xsl:value-of select="round(sum(/lista/osoba[@plec='k']/wiek) div count(/lista/osoba[@plec='k']) * 100) div 100" /></td></tr>
<tr><td><b><xsl:text>Srednia wieku mezczyzn: </xsl:text></b><xsl:value-of select="round(sum(/lista/osoba[@plec='m']/wiek) div count(/lista/osoba[@plec='m']) * 100) div 100" /></td></tr>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
