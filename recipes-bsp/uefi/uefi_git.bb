DESCRIPTION = "Unified Extensible Firmware Interface"
SECTION = "bootloaders"
LICENSE = "NXP-Binary-EULA"
LIC_FILES_CHKSUM = "file://NXP-Binary-EULA;md5=343ec8f06efc37467a6de53686fa6315"

inherit deploy

SRC_URI = "git://github.com/NXP/qoriq-uefi-binary.git;nobranch=1;protocol=https"
SRCREV = "55789d536850e00c6f2284fb28eaf21712cd276b"

do_install () {
       if [ -d ${B}/${MACHINE} ]; then
           install -d ${D}/uefi
           cp -r  ${B}/grub ${D}/uefi
           cp -r  ${B}/${MACHINE} ${D}/uefi
       fi
}

do_deploy () {
       if [ -d ${B}/${MACHINE} ]; then
           install -d ${DEPLOYDIR}/uefi
           cp -r  ${B}/grub   ${DEPLOYDIR}/uefi
           cp -r  ${B}/${MACHINE} ${DEPLOYDIR}/uefi
       fi
}
addtask deploy before do_build after do_install

PACKAGES += "${PN}-image"
FILES:${PN}-image += "/uefi/*"

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

COMPATIBLE_MACHINE = "(qoriq)"
