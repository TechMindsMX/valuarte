<?php
defined( '_JEXEC' ) or die( 'Restricted access' );
$document = JFactory::getDocument();

$modPath = 'modules/mod_carrete';
$document->addStyleSheet($modPath.'/css/mod_carrete.css');

$url 			= 'index.php?option=com_jumi&view=appliction&fileid=11&proyid=';
$urlinvertir 	= 'index.php?option=com_jumi&view=appliction&fileid=27&proyid=';

?>

<link href="<?php echo $modPath;?>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<?php echo $modPath;?>/lib/jquery.jcarousel.min.js"></script>
<link rel="stylesheet" type="text/css" href="<?php echo $modPath;?>/skins/tango/skin.css" />

<!--[if gte IE 9]>
  <style type="text/css">
    .gradient {
       filter: none;
    }
  </style>
<![endif]-->

<script type="text/javascript">
function mycarousel_initCallback(carousel) {
    // Disable autoscrolling if the user clicks the prev or next button.
    carousel.buttonNext.bind('click', function() {
        carousel.startAuto(0);
    });

    carousel.buttonPrev.bind('click', function() {
        carousel.startAuto(0);
    });

    // Pause autoscrolling if the user moves with the cursor over the clip.
    carousel.clip.hover(function() {
        carousel.stopAuto();
    }, function() {
        carousel.startAuto();
    });
};

jQuery(document).ready(function() {
	var scrollvar = 4;
	
	var isMobile = {
	    Android: function() { return navigator.userAgent.match(/Android/i); },
	    BlackBerry: function() { return navigator.userAgent.match(/BlackBerry/i); },
	    iOS: function() { return navigator.userAgent.match(/iPhone|iPad|iPod/i); }, 
	    Opera: function() { return navigator.userAgent.match(/Opera Mini/i); }, 
	    Windows: function() { return navigator.userAgent.match(/IEMobile/i);},
	};
	
	if (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows() ) {
		scrollvar = 1;
	} else{
		scrollvar = 4;
	}
	
	console.log(isMobile);
    jQuery('#mycarousel<?php echo $module->id; ?>').jcarousel({
        auto: 100,
        wrap: 'last',
        initCallback: mycarousel_initCallback,
        scroll: scrollvar
    });
});
</script>

<div id="wrap">
	<div class="vertodoscarrusel module-title">
  <h2 class="title"><a href="<?php echo $datos->viewAllUrl; ?>"><?php echo JText::_('VIEW_ALL'); ?> &gt; </a></h2>
 
</div>
	<ul id="mycarousel<?php echo $module->id; ?>" class="jcarousel-skin-tango">
  	<?php
	if(!is_null($datos->items) && @$datos->items[0] != ''){
	  	switch ($params->get('tipodepro')) {
			case 'cerrar':
		 		foreach ($datos->items as $key => $value) {
					echo '<li>
		    				<div class="contenedor proyectos">
		    					<a href="'.$url.@$value->id.'">
		    					<div class="avatar" style="background:url(\''.AVATAR.'/'.@$value->avatar.'\'); background-size: 100%;">
			    					<span class="mask"></span>
		    					</div>
		    					</a>
		    					<div class="info-proyecto">
									<div class="titulo">
										<a href="'.$url.@$value->id.'">
										<h2>'.@$value->name.'</h2>
										</a>
									</div>
									<div class="cat">
										<span>'.@$value->categoryName.'</span> - 
										<span>'.@$value->subcategoryName.'</span>
									</div>
									<div class="fondo_barra"><span class="barra" style="width: '.@$value->balancePorcentaje.'%;"></span></div>
									<div class="cat texto-proyectos recaudado">'.JText::_('LABEL_RECAUDADO').
									' $<span class="number">'.@$value->balance.'</span>
									</div>
									<div class="cat texto-proyectos">'.JText::_('PUNTO_EQUILIBRIO_ABR').
									' $<span class="number">'.@$value->breakeven.'</span>
									</div>
									<div class="cat texto-proyectos">'.JText::sprintf('LAPSED_DAYS', $value->dateDiff->days).'</div>
									<div class="boton-wrap">
										<a class="button btn-invertir" href="'.$urlinvertir.@$value->id.'">
											'.JText::_('INVERTIR_PROYECTO').'</a>
		    						</div>
		    					</div>
		    				</div>
		    			</li>';
				}
				break;
			case 'apoyados':
		 		foreach ($datos->items as $key => $value) {
		 			$value->trfFormateado = ($value->trfFormateado != null || $value->trfFormateado != 0) ? $value->trfFormateado.'%' : 'NA';
		 			$value->triFormateado = ($value->triFormateado != null || $value->triFormateado != 0) ? $value->triFormateado.'%' : 'NA';
					echo '<li>
		    				<div class="contenedor productos">
								<a href="'.$url.@$value->id.'">
		    						<div class="avatar" style="background:url(\''.AVATAR.'/'.@$value->avatar.'\'); background-size: 100%;">
		    						</div>
		    					</a>
		    					<div class="info-proyecto" >
									<div class="titulo">
										<a href="'.$url.@$value->id.'">
										<h2>'.@$value->name.'</h2>
										</a>
									</div>
									<div class="cat">
										<span>'.@$value->categoryName.'</span> - 
										<span>'.@$value->subcategoryName.'</span>
									</div>
									<div class="datos">
										<div class="two-cols first">
										<div class="big">'.@$value->trfFormateado.'</div>
										<div class="small">'.JText::_('LABEL_ROF').'</div>
										</div>
										<div class="two-cols second">
										<div class="big">'.@$value->triFormateado.'</div>
										<div class="small">'.JText::_('LABEL_ROI').'</div>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="boton-wrap">
										<a class="button btn-invertir" href="'.$urlinvertir.@$value->id.'">
											'.JText::_('INVERTIR_PROYECTO').'</a>
		    						</div>
		    					</div>
		    				</div>
		    			</li>';
				}
				break;
		  }
	  } else{
	  	echo '<p>'.JText::_('Sin datos').'</p>';
	  }
   	?>
  </ul>
</div>


