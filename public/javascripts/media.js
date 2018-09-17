function media() {
	primeiraNota = document.getElementById("notaPrimeiroB").value;
	segundaNota = document.getElementById("notaSegundoB").value;
	terceiraNota = document.getElementById("notaTerceiroB").value;
	quartaNota = document.getElementById("notaQuartoB").value;

	media = (primeiraNota+segundaNota+terceiraNota+quartaNota) / 4;

	document.getElementById("media").innerHtml = media;
}