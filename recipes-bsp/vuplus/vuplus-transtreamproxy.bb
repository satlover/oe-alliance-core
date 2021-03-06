SUMMARY = "streamproxy manages streaming data to a Mobile device using enigma2"
PRIORITY = "required"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r8"

PROVIDES += "virtual/transtreamproxy"
RPROVIDES_${PN} += "virtual/transtreamproxy"

SRC_URI = "git://code.vuplus.com/git/filestreamproxy.git;protocol=git;branch=transtreamproxy"

inherit autotools

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/bin
    install -m 0755 ${S}/src/transtreamproxy ${D}/usr/bin/transtreamproxy
}
