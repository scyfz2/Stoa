const nq_parse = {
	regexObject: {
		bolditalic: /(?:([\*_~]{1,3}))([^\*_~\n]+[^\*_~\s])\1/g,
		media: /!\[jumbox-([^\]<>]+)\]\(([^\)<>]+)\)\[jumbox-([^\]<>]+)\]/,
	},
	parseMedia(str) {
		var convertedresult = [];
		var stra = [];
		var includeVideo = {
			status: false,
			url: "",
		};
		var firstImage = {
			status: false,
			url: "",
		};
		while (str.length > 0) {
			stra = nq_parse.regexObject.media.exec(str);
			//console.log(str);
			//console.log(stra);
			if (stra !== null) {
				//console.log(stra);
				if (stra.index != 0) {
					convertedresult.push({
						mode: 'text',
						content: str.substring(0, stra.index),
					});
				};
				convertedresult.push({
					mode: stra[1],
					content: stra[2],
				});
				if (stra[1] == 'video' && includeVideo == false) {
					includeVideo.status = true;
					includeVideo.url = stra[2];
				};
				if (stra[1] == 'image' && firstImage.status == "") {
					firstImage.status = true;
					firstImage.url = stra[2];
				};
				str = str.substring(stra.index + stra[0].length);
			} else {

				convertedresult.push({
					mode: 'text',
					content: str,
				})
				str = "";
			};
			//console.log(convertedresult);
			//console.log(str.length);
		};
		return {
			data: convertedresult,
			firstImage,
			includeVideo,
		};
	},
	parsePureText(str) {
		var convertedresult = [];
		var stra = [];
		var includeVideo = {
			status: false,
			url: "",
		};
		var firstImage = {
			status: false,
			url: "",
		};
		var withoutMedia = "";
		while (str.length > 0) {
			stra = nq_parse.regexObject.media.exec(str);
			if (stra !== null) {
				//console.log(stra);
				if (stra.index != 0) {
					convertedresult = convertedresult + str.substring(0, stra.index);
					withoutMedia = convertedresult + str.substring(0, stra.index);
				};
				convertedresult = convertedresult + '[' + stra[1] + ']';
				if (stra[1] == 'video' && includeVideo.status == false) {
					includeVideo.status = true;
					includeVideo.url = stra[2];
				};
				if (stra[1] == 'image' && firstImage.status == false) {
					firstImage.status = true;
					firstImage.url = stra[2];
				};
				str = str.substring(stra.index + stra[0].length);
			} else {

				convertedresult = str;
				withoutMedia = str;
				str = "";
			};
			// console.log({
			// 	data: convertedresult,
			// 	firstImage,
			// 	includeVideo,
			// })
		};
		return {
			data: convertedresult,
			firstImage,
			includeVideo,
			withoutMedia:withoutMedia,
		};
	},
	parseText(str) {
		/* bold and italic */
		var i = 0;
		var stra = [];

		for (i = 0; i < 3; i++) {
			while ((stra = nq_parse.regexObject.bolditalic.exec(str)) !== null) {
				var repstr = [];
				if (stra[1] === '~~') {
					str = str.replace(stra[0], '<del>' + stra[2] + '</del>');
				} else {
					switch (stra[1].length) {
						case 1:
							repstr = ['<i>', '</i>'];
							break;
						case 2:
							repstr = ['<b>', '</b>'];
							break;
						case 3:
							repstr = ['<i><b>', '</b></i>'];
							break;
					}
					str = str.replace(stra[0], repstr[0] + stra[2] + repstr[1]);
				}
			}
		};
		return str;
	},
};

export default nq_parse;
