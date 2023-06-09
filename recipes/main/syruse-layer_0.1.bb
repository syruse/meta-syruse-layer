SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Main"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit qt6-cmake

SRC_URI = "file://*"

DEPENDS += " qtbase \
             qtdeclarative-native \
             qtquick3d"

#runtime dependancy for visualization over wayland api
RDEPENDS_${PN} += "qtwayland"

S = "${WORKDIR}"

# will be handled by cmake
#do_compile() {
#    ${CXX} main.cpp ${LDFLAGS} -o syruse-layer
#}

#do_install() {
#    install -d ${D}${bindir} # bindir = /usr/bin/
#    install -m 0755 syruse-layer ${D}${bindir}
#}

