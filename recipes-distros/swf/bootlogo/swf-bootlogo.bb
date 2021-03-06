SUMMARY = "swf bootlogo"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "swf"
PACKAGE_ARCH = "${MACHINE_ARCH}"

require conf/license/license-gplv2.inc

RDEPENDS_${PN} += "showiframe"

PV = "3.0"
PR = "r32"

S = "${WORKDIR}"

INITSCRIPT_NAME = "bootlogo"
INITSCRIPT_PARAMS = "start 06 S ."

inherit update-rc.d

SRC_URI = "file://bootlogo.mvi file://bootlogo1.mvi file://backdrop.mvi file://backdrop1.mvi file://bootlogo_wait.mvi file://radio.mvi file://bootlogo.sh ${@base_contains("MACHINE_FEATURES", "bootsplash", "file://splash.bin" , "", d)}"

FILES_${PN} = "/boot /usr/share /etc/init.d"

do_install() {
    install -d ${D}/usr/share
    install -m 0644 bootlogo.mvi ${D}/usr/share/bootlogo.mvi
    install -m 0644 backdrop.mvi ${D}/usr/share/backdrop.mvi
    install -m 0644 bootlogo_wait.mvi ${D}/usr/share/bootlogo_wait.mvi
    install -m 0644 bootlogo1.mvi ${D}/usr/share/bootlogo1.mvi
    install -m 0644 backdrop1.mvi ${D}/usr/share/backdrop1.mvi
    install -d ${D}/usr/share/enigma2/skin_default
    install -m 0644 radio.mvi ${D}/usr/share/enigma2/skin_default/radio.mvi
    install -d ${D}/${sysconfdir}/init.d
    install -m 0755 ${S}/bootlogo.sh ${D}/${sysconfdir}/init.d/bootlogo
}

inherit deploy
do_deploy() {
    if [ -e splash.bin ]; then
        install -m 0644 splash.bin ${DEPLOYDIR}/${BOOTLOGO_FILENAME}
    fi
}

addtask deploy before do_build after do_install
