CodeMirror.defineMode("basemode", function(config,parserConfig) {
	var keywords = parserConfig.keywords,
	stringCh = parserConfig ,
	isOperatorChar = parserConfig.isOperatorChar,
	commentSingle = parserConfig.commentSingle,
	commentMStart = parserConfig.commentMStart,
	commentMEnd = parserConfig.commentMEnd,
	escapeCh = parserConfig.escapeCh;
	function tokenize(stream,state){
		var ch = stream.next();
		var i=0;
		for(i;i<stringCh.length;i++){
			var strch = stringCh[i];
			if(strch==ch){
				var escaped = false, next, end = false;
				while ((next = stream.next()) != null) {
					if (next == strch && !escaped) {end = true; break;}
					escaped = !escaped && next == escapeCh;
				}
				return "string";

			}
		}


		if (/\d/.test(ch)) {
			stream.eatWhile(/[\w\.]/);
			return "number";
		}	
		
		if((ch == commentSingle.charAt(0)) && (stream.match(commentSingle.substring(1), true, false)) && state.tokenize!="comment"){
			stream.skipToEnd();
			return "comment";
		}
		if((ch == commentMStart.charAt(0)) && (stream.match(commentMStart.substring(1), true, false))){
			state.tokenize = "comment";
			return "comment";
		}
		if((ch == commentMEnd.charAt(0)) && (stream.match(commentMEnd.substring(1), true, false)) && state.tokenize == "comment"){

			state.tokenize = null;		
			return "comment";
		}


		
		if (isOperatorChar.test(ch)) {
			stream.eatWhile(isOperatorChar);
			return "operator";
		}

		stream.eatWhile(/[\w\$_]/);
		var cur = stream.current();
		if (keywords.propertyIsEnumerable(cur)) {
			return "keyword";

		}
	}
	function tokenCommentMultiple(stream,state){

		var cch;
		while(cch = stream.next()){

			if((cch == commentMEnd.charAt(0)) && (stream.match(commentMEnd.substring(1), true, false))){
				alert("sfds");
				state.tokenize = null;		
				break;
			}
		}
		return "comment";
	}
	return {
		startState : function(){
			return {
				tokenize : null
			};

		},
		token : function(stream, state){
			if(stream.eatSpace()) return null;
			var style = tokenize(stream, state);
			return (state.tokenize || style);
		}
	}

});
