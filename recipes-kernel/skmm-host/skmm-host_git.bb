DESCRIPTION = "skmm host driver offload data to PCIe EP and push the data en-decrypted back to application"
SECTION = "c293-skmm-host"
LICENSE = "BSD & GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=99803d8e9a595c0bdb45ca710f353813"

inherit  module qoriq_build_64bit_kernel

SRC_URI = "git://github.com/nxp-qoriq-yocto-sdk/skmm-host;protocol=https;nobranch=1"
SRCREV = "d5912ebdb8d3b29b1e2df52710e8821d1ce3eb80"

EXTRA_OEMAKE = 'KERNEL_DIR="${STAGING_KERNEL_DIR}" PREFIX="${D}"'

FILES:${PN} += "/etc/skmm/ /usr/bin/"

COMPATIBLE_MACHINE = "(p4080ds|t4240qds)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

CLEANBROKEN = "1"
