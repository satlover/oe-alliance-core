SUMMARY = "Simple tool for input event debugging."
HOMEPAGE = "http://people.freedesktop.org/~whot/evtest/"
AUTHOR = "Vojtech Pavlik <vojtech@suse.cz>"
SECTION = "console/utils"
#PRIORITY = "optional"
LICENSE = "GPLv2"
PR = "r2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"


DEPENDS = "libxml2"

SRC_URI = "http://cgit.freedesktop.org/~whot/evtest/snapshot/evtest-${PV}.tar.bz2;name=archive"

inherit autotools

do_install () {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/${PN}-${PV}/evtest ${D}${bindir}/evtest
}

FILES_${PN} = "${bindir}/evtest"

INHIBIT_AUTO_STAGE = "1"

SRC_URI[archive.md5sum] = "770d6af03affe976bdbe3ad1a922c973"
SRC_URI[archive.sha256sum] = "3d34123c68014dae6f7c19144ef79ea2915fa7a2f89ea35ca375a9cf9e191473"
