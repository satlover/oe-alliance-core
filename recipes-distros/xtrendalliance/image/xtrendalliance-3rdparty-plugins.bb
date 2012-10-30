DESCRIPTION = "3rd Party plugins for Enigma2"
MAINTAINER = "xtrendalliance team"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=8e37f34d0e40d32ea2bc90ee812c9131"

inherit gitpkgv

SRCREV = "${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r0"

SRC_URI="git://github.com/oe-alliance/3rdparty-plugins.git;protocol=git"

EXTRA_OECONF = " \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	--with-boxtype=${MACHINE} \
"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools

S = "${WORKDIR}/git"

DEPENDS = "enigma2 enigma2-3rdparty-plugins"

do_install() {
	install -d 0644 ${DEPLOY_DIR_IPK}/3rdparty
	install -m 0644 ${S}/enigma2-plugin-extensions-et-portal-inofficial_1.8_all.ipk ${DEPLOY_DIR_IPK}/3rdparty
}
