DESCRIPTION = "Configuration files for secret feeds"


require conf/license/license-gplv2.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r0"

do_compile() {

mkdir -p ${S}/${sysconfdir}/opkg

echo "src/gz secret-feeds2 http://secret.mynonpublic.com" > ${S}/${sysconfdir}/opkg/secret-feed2.conf

}

do_install () {

install -d ${D}${sysconfdir}/opkg

install -m 0644 ${S}/${sysconfdir}/opkg/secret-feed2.conf ${D}${sysconfdir}/opkg/

}

CONFFILES_${PN} = '${sysconfdir}/opkg/secret-feed2.conf'

