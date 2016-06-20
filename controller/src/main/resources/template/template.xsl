<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
    <xsl:template match="curriculum">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format" font-family="Arial" font-size="9pt">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm"
                                       margin-top="2cm" margin-bottom="2cm" margin-left="2cm"
                                       margin-right="2cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align="center" space-after="2mm">
                        Львівський національний університет імені Івана Франка
                    </fo:block>
                    <fo:block text-align="center" space-after="8mm">
                        Кафедра теорії оптимальних процесів
                    </fo:block>
                    <fo:block font-weight="bold" start-indent="20mm" space-after="2mm">
                        “ЗАТВЕРДЖУЮ”
                    </fo:block>
                    <fo:block space-after="8mm">
                        Проректор з навчальної роботи
                    </fo:block>
                    <fo:block space-after="2mm">
                        ___________________________
                    </fo:block>
                    <fo:block space-after="13mm">
                        “______”_______________2013 р.
                    </fo:block>
                    <fo:block font-style="italic" font-weight="bold" text-align="center"
                              space-after="5mm">
                        ПРОГРАМА НАВЧАЛЬНОЇ ДИСЦИПЛІНИ
                    </fo:block>
                    <fo:block font-weight="bold" text-align="center" space-after="5mm">
                        <xsl:value-of select="name"/>
                    </fo:block>
                    <fo:block space-after="2mm">
                        галузь знань
                        <fo:inline font-style="italic">
                            <xsl:value-of select="knowledgeBranch"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block space-after="2mm">
                        напряму підготовки
                        <fo:inline font-style="italic">
                            <xsl:value-of select="trainingDirection"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block space-after="2mm">
                        для спеціальності
                        <fo:inline font-style="italic">
                            <xsl:value-of select="specialty"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block space-after="2mm">
                        факультету
                        <fo:inline font-style="italic">
                            <xsl:value-of select="faculty"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block space-after="15mm">
                        кваліфікаційний рівень –
                        <fo:inline font-style="italic">
                            <xsl:value-of select="qualificationLevel"/>
                        </fo:inline>
                    </fo:block>


                    <fo:block>
                        <fo:table table-layout="fixed" width="100%" border-collapse="collapse">
                            <fo:table-column column-width="16mm"/>
                            <fo:table-column column-width="1cm"/>
                            <fo:table-column column-width="1cm"/>
                            <fo:table-column column-width="12mm"/>
                            <fo:table-column column-width="13mm"/>
                            <fo:table-column column-width="12mm"/>
                            <fo:table-column column-width="12mm"/>
                            <fo:table-column column-width="12mm"/>
                            <fo:table-column column-width="12mm"/>
                            <fo:table-column column-width="15mm"/>
                            <fo:table-column column-width="15mm"/>
                            <fo:table-column column-width="12mm"/>
                            <fo:table-column column-width="1cm"/>
                            <fo:table-column column-width="1cm"/>
                            <fo:table-header>
                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center" number-rows-spanned="2">
                                        <fo:block text-align="center">Форма навчання</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   number-rows-spanned="2" display-align="center">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="40mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Курс
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   number-rows-spanned="2" display-align="center">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="40mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Семестр
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   number-rows-spanned="2" display-align="center">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="40mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Загальний обсяг
                                            </fo:block>
                                            <fo:block text-align="center">
                                                (год.)
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   number-rows-spanned="2" display-align="center">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="40mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Всього аудит.
                                            </fo:block>
                                            <fo:block text-align="center">
                                                (год.)
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center"
                                                   number-columns-spanned="3">
                                        <fo:block text-align="center">у тому числі (год.):
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="30mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Самостійна робота (год.)
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="30mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Контрольні (модульні) роботи (шт.)
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="30mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Розрахунково-графічні роботи (шт.)
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="30mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Курсові проекти (роботи), (шт.)
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="30mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Залік (сем.)
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="30mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Екза-мен (сем.)
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="30mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Лекції
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="30mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Лабораторні
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid">
                                        <fo:block-container
                                                reference-orientation="90" display-align="center"
                                                inline-progression-dimension.minimum="5mm"
                                                inline-progression-dimension.optimum="30mm"
                                                inline-progression-dimension.maximum="auto">
                                            <fo:block text-align="center">
                                                Практичні
                                            </fo:block>
                                        </fo:block-container>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-header>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm">
                                            <xsl:value-of select="studyForm"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm">
                                            <xsl:value-of select="course"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm">
                                            <xsl:value-of select="term"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm">
                                            <xsl:value-of select="curriculumSum"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm">
                                            <xsl:value-of select="auditoriumSum"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm">
                                            <xsl:value-of select="lecturesSum"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm">
                                            <xsl:value-of select="laboratoriesSum"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm"></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm">
                                            <xsl:value-of select="individualWork"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm">
                                            <xsl:value-of select="colloquium"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm"></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm"></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm">+</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" padding="3mm"></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        Робоча програма складена на основі:
                        <fo:inline font-weight="bold">освітньо-професійної програми</fo:inline>
                        ГСВО
                    </fo:block>
                    <fo:block space-after="2mm">
                        напряму
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="trainingDirection"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block space-after="2mm" font-weight="bold">
                        варіативної частини освітньо-професійної програми
                    </fo:block>
                    <fo:block space-after="2mm">
                        спеціальності
                        <fo:inline>
                            <xsl:value-of select="specialty"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block space-after="10mm">
                        Робочу програму склав
                    </fo:block>
                    <fo:block space-after="10mm">
                        Робоча програма затверджена на засіданні
                    </fo:block>
                    <fo:block space-after="10mm">
                        Протокол № ___ від. “____”________________2013 р.
                    </fo:block>
                    <fo:block space-after="10mm" text-align="right">
                        Завідувач кафедрою________________________ /Бартіш М. Я./
                    </fo:block>


                </fo:flow>
            </fo:page-sequence>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-weight="bold" text-align="center" space-after="5mm">
                        1. РІВЕНЬ СФОРМОВАНОСТІ ВМІНЬ І ЗНАНЬ
                    </fo:block>
                    <fo:block space-after="5mm">
                        <fo:table table-layout="fixed" width="100%" border-collapse="collapse">
                            <fo:table-column column-width="16mm"/>
                            <fo:table-column column-width="auto"/>
                            <fo:table-header>
                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">Шифр змісто- вого модуля
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">Зміст умінь і знань, що
                                            забезпечується
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-header>
                            <fo:table-body>
                                <xsl:apply-templates select="module"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    <fo:block font-weight="bold" text-align="center" space-after="5mm">
                        2. ІНФОРМАЦІЙНИЙ ОБСЯГ ДИСЦИПЛІНИ
                    </fo:block>
                    <fo:block font-weight="bold">
                        2.1. Лекційний курс
                    </fo:block>
                    <fo:block space-after="5mm">
                        <fo:table table-layout="fixed" width="100%" border-collapse="collapse">
                            <fo:table-column column-width="16mm"/>
                            <fo:table-column column-width="auto"/>
                            <fo:table-column column-width="16mm"/>
                            <fo:table-header>
                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">Шифр змісто- вого мо- дуля
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">Назва змістового модуля
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">Кіль-кість ауд. годин
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-header>
                            <fo:table-body>
                                <xsl:apply-templates select="lectures"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    <fo:block font-weight="bold">
                        2.2. Лабораторні заняття
                    </fo:block>
                    <fo:block space-after="5mm">
                        <fo:table table-layout="fixed" width="100%" border-collapse="collapse">
                            <fo:table-column column-width="16mm"/>
                            <fo:table-column column-width="auto"/>
                            <fo:table-column column-width="16mm"/>
                            <fo:table-header>
                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">Шифр змісто- вого мо- дуля
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">Назва змістового модуля
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">Кіль-кість ауд. годин
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-header>
                            <fo:table-body>
                                <xsl:apply-templates select="lectures"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    <fo:block font-weight="bold">
                        2.3.Самостійна робота студента
                        <fo:inline font-weight="normal" font-style="italic">
                            (денна форма навчання)
                        </fo:inline>

                    </fo:block>
                    <fo:block space-after="5mm">
                        <fo:table>
                            <fo:table-column column-width="16mm"/>
                            <fo:table-column column-width="auto"/>
                            <fo:table-column column-width="auto"/>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell display-align="center">
                                        <fo:block text-align="left">-</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell display-align="center">
                                        <fo:block text-align="left">підготовка до лабораторних
                                            занять:  
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell display-align="center">
                                        <fo:block text-align="left" font-weight="bold">
                                            <xsl:value-of select="laboratoriesCount"/> тижнів х
                                            <xsl:value-of select="laboratoryDuration"/> год.=
                                            <xsl:value-of select="laboratorySum"/> год;
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell display-align="center">
                                        <fo:block text-align="left">-</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell display-align="center">
                                        <fo:block text-align="left">підготовка до колоквіуму
                                            (модуля): 
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell text-align="left" font-weight="bold">
                                        <fo:block text-align="left" font-weight="bold">
                                            <xsl:value-of select="colloquium"/> модуля х
                                            <xsl:value-of select="colloquiumDuration"/> год.=
                                            <xsl:value-of select="colloquiumSum"/> год.
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell display-align="center">
                                        <fo:block text-align="left">-</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell display-align="left">
                                        <fo:block text-align="left">усього:</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell display-align="center">
                                        <fo:block text-align="left" font-weight="bold">
                                            <xsl:value-of select="generalDuration"/> год.
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>

            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body">

                    <fo:block space-after="2mm" font-weight="bold">
                        3. ПЕРЕЛІК РЕКОМЕНДОВАНИХ ПІДРУЧНИКІВ І НАВЧАЛЬНИХ ПОСІБНИКІВ
                    </fo:block>

                    <fo:block space-after="5mm">
                        <fo:table width="100%">
                            <fo:table-column column-width="5mm"/>
                            <fo:table-column column-width="auto"/>
                            <fo:table-body>
                                <xsl:apply-templates select="textbooks"/>
                            </fo:table-body>
                        </fo:table>

                    </fo:block>

                    <fo:block space-after="2mm" font-weight="bold">
                        4. КРИТЕРІЇ УСПІШНОСТІ
                    </fo:block>

                    <fo:block space-after="2mm" font-weight="normal">
                        Оцінювання знань студента на протязі року здійснюється за 100-бальною
                        шкалою:
                    </fo:block>

                    <fo:block space-after="2mm" text-align="right">
                        за поточну успішність – 50 балів;
                    </fo:block>

                    <fo:block space-after="2mm" text-align="right">
                        на заліку – 50 балів.
                    </fo:block>

                    <fo:block font-weight="bold">
                        Таблиця 1. Шкала оцінювання: вузу,

                        <fo:inline font-weight="normal">
                            національна та ECTS
                        </fo:inline>
                    </fo:block>
                    <fo:block space-after="5mm">
                        <fo:table table-layout="fixed" width="100%" border-collapse="collapse">
                            <fo:table-column column-width="30mm"/>
                            <fo:table-column column-width="16mm"/>
                            <fo:table-column column-width="40mm"/>
                            <fo:table-body>

                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center" number-rows-spanned="2">
                                        <fo:block text-align="center">Оцінка ECTS</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center" number-rows-spanned="2">
                                        <fo:block text-align="center">Оцінка в балах</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center"
                                                   number-columns-spanned="3">

                                        <fo:block text-align="center">За національною шкалою
                                        </fo:block>


                                    </fo:table-cell>
                                </fo:table-row>


                                <fo:table-row>


                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center"
                                                   number-columns-spanned="2">

                                        <fo:block text-align="center">Екземенаційна оцінка
                                        </fo:block>


                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">

                                        <fo:block text-align="center">Залік</fo:block>


                                    </fo:table-cell>
                                </fo:table-row>


                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" font-weight="bold">A
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">90-100</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">5</fo:block>
                                    </fo:table-cell>

                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" font-style="italic">Відмінно
                                        </fo:block>
                                    </fo:table-cell>


                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center" number-rows-spanned="5">
                                        <fo:block text-align="center" font-style="italic">
                                            Зараховано
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" font-weight="bold">B
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">81-89</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center" number-rows-spanned="2">
                                        <fo:block text-align="center">4</fo:block>
                                    </fo:table-cell>

                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" font-style="italic">Дуже
                                            добре
                                        </fo:block>
                                    </fo:table-cell>


                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" font-weight="bold">С
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">71-80</fo:block>
                                    </fo:table-cell>


                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" font-style="italic">Добре
                                        </fo:block>
                                    </fo:table-cell>


                                </fo:table-row>


                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" font-weight="bold">D
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">61-70</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center" number-rows-spanned="2">
                                        <fo:block text-align="center">3</fo:block>
                                    </fo:table-cell>

                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" font-style="italic">
                                            Задовільно
                                        </fo:block>
                                    </fo:table-cell>


                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" font-weight="bold">Е
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center">51-60</fo:block>
                                    </fo:table-cell>


                                    <fo:table-cell border-width="1pt" border-style="solid"
                                                   display-align="center">
                                        <fo:block text-align="center" font-style="italic">
                                            Достатньо
                                        </fo:block>
                                    </fo:table-cell>


                                </fo:table-row>

                            </fo:table-body>


                        </fo:table>
                    </fo:block>
                    <fo:block space-after="2mm" font-weight="bold">
                        5.ЗАСОБИ ДІАГНОСТИКИ ПОТОЧНОЇ УСПІШНОСТІ
                    </fo:block>
                    <fo:block space-after="2mm" font-weight="normal">
                        Протягом семестру проводиться
                        <fo:inline font-weight="bold">
                            два
                        </fo:inline>
                        <fo:inline font-weight="normal" font-style="italic">
                            колоквіуми
                        </fo:inline>
                        <fo:inline font-weight="normal">
                            (модулі)
                        </fo:inline>
                    </fo:block>
                    <fo:block space-after="2mm" font-weight="normal">
                        Виконання домашніх завдань, відповіді та самостійна робота на лабораторних
                        заняттях (максимум):
                        <fo:inline font-weight="bold">
                            <xsl:apply-templates select="laboratoriesProgress"/>
                            балів.
                        </fo:inline>
                    </fo:block>
                    <fo:block space-after="2mm" font-weight="normal">
                        Розподіл балів між темами оголошується на початку року.
                    </fo:block>
                    <fo:block space-after="2mm" font-weight="normal">
                        Результати колоквіумів (максимум):
                        <fo:inline font-weight="bold">
                            2 х 20 = 40 балів.
                        </fo:inline>
                    </fo:block>
                    <fo:block space-after="5cm" font-weight="bold" text-align="right">
                        <fo:inline font-weight="bold">
                            Усього
                            <xsl:apply-templates select="laboratoriesProgress"/>
                            +
                        </fo:inline>

                        <fo:inline font-weight="bold">
                            <xsl:apply-templates select="colloquiumProgress"/>
                            =
                        </fo:inline>
                        <fo:inline font-weight="bold">
                            <xsl:apply-templates select="progressSum"/>
                            балів.
                        </fo:inline>

                    </fo:block>

                    <fo:block font-weight="normal" font-style="italic" text-align="left">
                        <!--TO DO-->
                        Автор
                        <fo:block font-weight="normal" font-style="italic" text-align="right">
                            <!--TO DO-->
                            /Мельничин А. В./
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
    <xsl:template match="module">
        <fo:table-row>
            <fo:table-cell border-width="1pt" border-style="solid" padding="1mm"
                           display-align="center">
                <fo:block font-style="italic" font-weight="bold" text-align="center">
                    ЗМ<xsl:value-of select="code"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell border-width="1pt" border-style="solid" padding="1mm">
                <fo:block>
                    <fo:inline font-weight="bold">
                        <xsl:value-of select="name"/>
                    </fo:inline>
                    <fo:inline start-indent="2mm">
                        <xsl:value-of select="description"/>
                    </fo:inline>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    <xsl:template match="lectures">
        <fo:table-row>
            <fo:table-cell border-width="1pt" border-style="solid" padding="1mm"
                           display-align="center">
                <fo:block font-style="italic" text-align="center">
                    ЗМ<xsl:value-of select="code"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell border-width="1pt" border-style="solid" padding="1mm">
                <fo:block font-weight="bold">
                    <xsl:value-of select="name"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell border-width="1pt" border-style="solid" padding="1mm">
                <fo:block text-align="center">
                    <xsl:value-of select="laboratories"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    <xsl:template match="laboratories">
        <fo:table-row>
            <fo:table-cell border-width="1pt" border-style="solid" padding="1mm"
                           display-align="center">
                <fo:block font-style="italic" text-align="center">
                    ЗМ<xsl:value-of select="code"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell border-width="1pt" border-style="solid" padding="1mm">
                <fo:block font-weight="bold">
                    <xsl:value-of select="name"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell border-width="1pt" border-style="solid" padding="1mm">
                <fo:block text-align="center">
                    <xsl:value-of select="laboratories"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
    <xsl:template match="textbooks">
        <fo:table-row>

            <fo:table-cell border-width="1pt" border-style="none" padding="1mm">
                <fo:block font-style="italic">
                    <xsl:value-of select="code"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell border-width="1pt" border-style="none" padding="1mm">
                <fo:block font-style="italic">
                    <xsl:value-of select="description"/>
                </fo:block>
            </fo:table-cell>

        </fo:table-row>
    </xsl:template>
</xsl:stylesheet>
